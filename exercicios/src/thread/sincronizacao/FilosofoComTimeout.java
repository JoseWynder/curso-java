package thread.sincronizacao;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ThreadLocalRandom;

public class FilosofoComTimeout implements Runnable {
    private final Lock leftFork;
    private final Lock rightFork;
    private static final int TIMEOUT = 1000; // Tempo limite em milissegundos

    public FilosofoComTimeout(Lock leftFork, Lock rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                if (!eat()) {
                    // Não conseguiu pegar os garfos a tempo, vai pensar novamente
                    System.out.println(Thread.currentThread().getName() + " não conseguiu pegar os garfos a tempo e vai pensar novamente.");
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " está pensando.");
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
    }

    private boolean eat() throws InterruptedException {
        if (leftFork.tryLock(TIMEOUT, TimeUnit.MILLISECONDS)) {
            try {
                if (rightFork.tryLock(TIMEOUT, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " está comendo.");
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                        return true;
                    } finally {
                        rightFork.unlock();
                    }
                }
            } finally {
                leftFork.unlock();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Lock fork1 = new ReentrantLock();
        Lock fork2 = new ReentrantLock();
        Lock fork3 = new ReentrantLock();
        Lock fork4 = new ReentrantLock();
        Lock fork5 = new ReentrantLock();

        FilosofoComTimeout[] filosofos = new FilosofoComTimeout[5];
        filosofos[0] = new FilosofoComTimeout(fork1, fork2);
        filosofos[1] = new FilosofoComTimeout(fork2, fork3);
        filosofos[2] = new FilosofoComTimeout(fork3, fork4);
        filosofos[3] = new FilosofoComTimeout(fork4, fork5);
        filosofos[4] = new FilosofoComTimeout(fork5, fork1);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(filosofos[i], "Filosofo " + (i + 1));
            threads[i].start();
        }
    }
}
