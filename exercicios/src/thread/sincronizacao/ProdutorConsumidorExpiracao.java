package thread.sincronizacao;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdutorConsumidorExpiracao {
    private static final PriorityQueue<Item> queue = new PriorityQueue<>();
    private static final Lock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final long EXPIRATION_TIME = 5000; // Tempo de expiração em milissegundos

    public static void main(String[] args) {
        // Iniciando threads produtoras e consumidoras
        for (int i = 0; i < 2; i++) {
            new Thread(new Produtor(), "Produtor " + (i + 1)).start();
            new Thread(new Consumidor(), "Consumidor " + (i + 1)).start();
        }
    }

    static class Item implements Comparable<Item> {
        private final long timestamp;
        private final int value;

        public Item(int value) {
            this.timestamp = System.currentTimeMillis();
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return Long.compare(this.timestamp, o.timestamp); // Comparar pelo tempo de criação
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - timestamp > EXPIRATION_TIME;
        }

        @Override
        public String toString() {
            return "Item{" + "value=" + value + ", timestamp=" + timestamp + '}';
        }
    }

    static class Produtor implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        int value = (int) (Math.random() * 100);
                        queue.offer(new Item(value));
                        System.out.println(Thread.currentThread().getName() + " produziu: " + value);
                        notEmpty.signal();
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(500); // Pausa para simular tempo de produção
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumidor implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        while (queue.isEmpty()) {
                            notEmpty.await();
                        }
                        Item item = queue.peek();
                        if (item != null && item.isExpired()) {
                            queue.poll(); // Remove o item expirado
                            System.out.println(Thread.currentThread().getName() + " descartou item expirado: " + item);
                        } else if (item != null) {
                            System.out.println(Thread.currentThread().getName() + " consumiu: " + queue.poll());
                        }
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(500); // Pausa para simular tempo de consumo
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
