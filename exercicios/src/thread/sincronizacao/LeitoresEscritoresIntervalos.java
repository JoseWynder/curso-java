package thread.sincronizacao;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeitoresEscritoresIntervalos {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int readers = 0;
    private static boolean writerActive = false;
    private static int data = 0;

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
                        while (writerActive) {
                            System.out.println(Thread.currentThread().getName() + " está esperando para ler (escritor ativo).");
                            condition.await();
                        }
                        readers++; // Incrementa o número de leitores ativos
                    } finally {
                        lock.unlock();
                    }

                    read();

                    lock.lock();
                    try {
                        readers--; // Decrementa o contador de leitores
                        if (readers == 0) {
                            condition.signalAll(); // Sinaliza se não houver mais leitores
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
            System.out.println(Thread.currentThread().getName() + " está lendo dados: " + data);
        }
    }

    static class Writer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        while (readers > 0 || writerActive) {
                            System.out.println(Thread.currentThread().getName() + " está esperando para escrever (leitores ou escritor ativo).");
                            condition.await();
                        }
                        writerActive = true; // Marca o escritor como ativo
                    } finally {
                        lock.unlock();
                    }

                    write();

                    lock.lock();
                    try {
                        writerActive = false; // Marca o escritor como inativo
                        condition.signalAll(); // Sinaliza que o escritor terminou
                    } finally {
                        lock.unlock();
                    }

                    Thread.sleep(2000); // Intervalo de atualização de dados (2 segundos)
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void write() {
            data++;
            System.out.println(Thread.currentThread().getName() + " atualizou dados para: " + data);
        }
    }
}
