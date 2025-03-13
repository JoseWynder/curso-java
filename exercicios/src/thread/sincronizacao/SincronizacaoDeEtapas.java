package thread.sincronizacao;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SincronizacaoDeEtapas {
    private static final int N = 5; // Número de threads
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int completedStages = 0;

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            new Thread(new Task(), "Thread " + (i + 1)).start();
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                for (int stage = 0; stage < 3; stage++) {
                    doStageWork(stage);
                    synchronizeStage();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void doStageWork(int stage) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " está na etapa " + stage);
            Thread.sleep(500); // Simula trabalho na etapa
        }

        private void synchronizeStage() throws InterruptedException {
            lock.lock();
            try {
                completedStages++;
                if (completedStages < N) {
                    System.out.println(Thread.currentThread().getName() + " está aguardando as outras threads.");
                    condition.await();
                } else {
                    completedStages = 0;
                    System.out.println("Todas as threads completaram a etapa. Prosseguindo para a próxima etapa.");
                    condition.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
