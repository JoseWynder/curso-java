package thread.sincronizacao;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdutorConsumidorPrioridade {
    private static final PriorityQueue<Item> queue = new PriorityQueue<>();
    private static final Lock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) { // Exemplo com dois produtores
            new Thread(new Produtor(), "Produtor " + (i + 1)).start();
        }
        for (int i = 0; i < 2; i++) { // Exemplo com dois consumidores
            new Thread(new Consumidor(), "Consumidor " + (i + 1)).start();
        }
    }

    static class Item implements Comparable<Item> {
        private final int priority;
        private final int value;

        public Item(int priority, int value) {
            this.priority = priority;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(o.priority, this.priority);
        }

        @Override
        public String toString() {
            return "Item{" + "priority=" + priority + ", value=" + value + '}';
        }
    }

    static class Produtor implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();
                    try {
                        int priority = (int) (Math.random() * 10);
                        int value = (int) (Math.random() * 100);
                        queue.offer(new Item(priority, value));
                        System.out.println(Thread.currentThread().getName() + " produziu: " + value + " com prioridade " + priority);
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
                        Item item = queue.poll();
                        if (item != null) {
                            System.out.println(Thread.currentThread().getName() + " consumiu: " + item);
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
