package thread.sincronizacao;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ThreadLocalRandom;

public class Filosofo implements Runnable {
    private final Lock leftFork;
    private final Lock rightFork;
    private static final Lock eatingLock = new ReentrantLock();
    private static final Condition canEat = eatingLock.newCondition();
    private static int eatingCount = 0;

    public Filosofo(Lock leftFork, Lock rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " está pensando.");
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
    }

    private void eat() throws InterruptedException {
        eatingLock.lock();
        try {
            while (eatingCount >= 2) {
                canEat.await();
            }
            eatingCount++;
        } finally {
            eatingLock.unlock();
        }

        leftFork.lock();
        rightFork.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " está comendo.");
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
        } finally {
            rightFork.unlock();
            leftFork.unlock();
            
            eatingLock.lock();
            try {
                eatingCount--;
                canEat.signalAll();
            } finally {
                eatingLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Lock fork1 = new ReentrantLock();
        Lock fork2 = new ReentrantLock();
        Lock fork3 = new ReentrantLock();
        Lock fork4 = new ReentrantLock();
        Lock fork5 = new ReentrantLock();

        Filosofo[] filosofos = new Filosofo[5];
        filosofos[0] = new Filosofo(fork1, fork2);
        filosofos[1] = new Filosofo(fork2, fork3);
        filosofos[2] = new Filosofo(fork3, fork4);
        filosofos[3] = new Filosofo(fork4, fork5);
        filosofos[4] = new Filosofo(fork5, fork1);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(filosofos[i], "Filosofo " + (i + 1));
            threads[i].start();
        }
    }
}
