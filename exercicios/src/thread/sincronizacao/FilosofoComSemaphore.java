package thread.sincronizacao;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ThreadLocalRandom;

public class FilosofoComSemaphore implements Runnable {
    private final Lock leftFork;
    private final Lock rightFork;
    private static final Semaphore eatingSemaphore = new Semaphore(2);

    public FilosofoComSemaphore(Lock leftFork, Lock rightFork) {
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
        eatingSemaphore.acquire();
        leftFork.lock();
        rightFork.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " está comendo.");
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
        } finally {
            rightFork.unlock();
            leftFork.unlock();
            eatingSemaphore.release();
        }
    }

    public static void main(String[] args) {
        Lock fork1 = new ReentrantLock();
        Lock fork2 = new ReentrantLock();
        Lock fork3 = new ReentrantLock();
        Lock fork4 = new ReentrantLock();
        Lock fork5 = new ReentrantLock();

        FilosofoComSemaphore[] filosofos = new FilosofoComSemaphore[5];
        filosofos[0] = new FilosofoComSemaphore(fork1, fork2);
        filosofos[1] = new FilosofoComSemaphore(fork2, fork3);
        filosofos[2] = new FilosofoComSemaphore(fork3, fork4);
        filosofos[3] = new FilosofoComSemaphore(fork4, fork5);
        filosofos[4] = new FilosofoComSemaphore(fork5, fork1);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(filosofos[i], "Filosofo " + (i + 1));
            threads[i].start();
        }
    }
}
