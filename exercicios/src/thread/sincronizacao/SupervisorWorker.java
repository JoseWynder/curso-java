package thread.sincronizacao;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SupervisorWorker {
    private static final Lock lock = new ReentrantLock();
    private static final Condition workCondition = lock.newCondition();

    public static void main(String[] args) {
        Thread supervisor = new Thread(() -> {
            try {
                while (true) {
                    lock.lock();
                    try {
                        // Sinaliza os trabalhadores para começar
                        System.out.println("Supervisor: Sinalizando trabalhadores para começar a trabalhar.");
                        workCondition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(1000); // Intervalo entre rodadas de trabalho
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        supervisor.start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(), "Worker " + (i + 1)).start();
        }
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " está aguardando o sinal do supervisor.");
                        workCondition.await();
                        // Simula trabalho
                        System.out.println(Thread.currentThread().getName() + " está trabalhando.");
                        Thread.sleep(500); // Tempo de trabalho
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
