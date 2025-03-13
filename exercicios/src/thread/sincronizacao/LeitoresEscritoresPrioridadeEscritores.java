package thread.sincronizacao;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeitoresEscritoresPrioridadeEscritores {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int readers = 0;
    private static boolean writerActive = false;

    public static void main(String[] args) {
        // Inicia 5 leitores e 5 escritores para teste
        for (int i = 0; i < 5; i++) {
            new Thread(new Reader(), "Leitor " + (i + 1)).start();
            new Thread(new Writer(), "Escritor " + (i + 1)).start();
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        // Espera enquanto houver escritor ativo
                        while (writerActive) {
                            condition.await();
                        }
                        readers++; // Incrementa o número de leitores ativos
                    } finally {
                        lock.unlock();
                    }

                    read();

                    lock.lock();
                    try {
                        readers--; // Decrementa o número de leitores ativos
                        if (readers == 0) {
                            condition.signalAll(); // Se não houver mais leitores, permite que o escritor atue
                        }
                    } finally {
                        lock.unlock();
                    }

                    Thread.sleep(500); // Tempo para simular leitura
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void read() {
            System.out.println(Thread.currentThread().getName() + " está lendo.");
        }
    }

    static class Writer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        // Espera se houver leitores ou outro escritor ativo
                        while (readers > 0 || writerActive) {
                            condition.await();
                        }
                        writerActive = true; // Marca que um escritor está ativo
                    } finally {
                        lock.unlock();
                    }

                    write();

                    lock.lock();
                    try {
                        writerActive = false; // Marca que o escritor terminou
                        condition.signalAll(); // Sinaliza todos (leitores e escritores) para continuar
                    } finally {
                        lock.unlock();
                    }

                    Thread.sleep(500); // Tempo para simular escrita
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void write() {
            System.out.println(Thread.currentThread().getName() + " está escrevendo.");
        }
    }
}
