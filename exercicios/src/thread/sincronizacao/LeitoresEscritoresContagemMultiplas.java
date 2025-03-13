package thread.sincronizacao;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeitoresEscritoresContagemMultiplas {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static final int MAX_READS = 3; // Limite de leitores simultâneos
    private static int readers = 0; // Contador de leitores
    private static int readCount = 0; // Contador de leituras simultâneas
    private static boolean writerActive = false; // Flag para escritor ativo

    public static void main(String[] args) {
        // Criando múltiplos leitores e escritores
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
                        // Aguarda enquanto houver escritor ativo ou o limite de leituras for atingido
                        while (writerActive || readCount >= MAX_READS) {
                            condition.await();
                        }
                        readers++; // Incrementa o contador de leitores
                        readCount++; // Incrementa o contador de leituras simultâneas
                    } finally {
                        lock.unlock();
                    }

                    read();

                    lock.lock();
                    try {
                        readers--; // Decrementa o contador de leitores
                        if (readers == 0) { // Se todos os leitores terminaram, libera o escritor
                            readCount = 0;
                            condition.signalAll();
                        }
                    } finally {
                        lock.unlock();
                    }

                    Thread.sleep(500); // Simula o tempo de leitura
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
                        // Aguarda se houver leitores ou outro escritor ativo
                        while (readers > 0 || writerActive) {
                            condition.await();
                        }
                        writerActive = true; // Marca que o escritor está ativo
                    } finally {
                        lock.unlock();
                    }

                    write();

                    lock.lock();
                    try {
                        writerActive = false; // Marca que o escritor terminou
                        condition.signalAll(); // Libera leitores e outros escritores
                    } finally {
                        lock.unlock();
                    }

                    Thread.sleep(500); // Simula o tempo de escrita
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
