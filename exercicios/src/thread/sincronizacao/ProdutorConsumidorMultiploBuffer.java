package thread.sincronizacao;

import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;

@SuppressWarnings("unchecked")
public class ProdutorConsumidorMultiploBuffer {
	
	private static final BlockingQueue<Integer>[] buffers = new ArrayBlockingQueue[3];

    static {
        for (int i = 0; i < buffers.length; i++) {
            buffers[i] = new ArrayBlockingQueue<>(10); // Buffers com tamanhos iguais (pode ser ajustado conforme necessário)
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) { // Exemplo com dois produtores
            new Thread(new Produtor(), "Produtor " + (i + 1)).start();
        }
        for (int i = 0; i < 2; i++) { // Exemplo com dois consumidores
            new Thread(new Consumidor(), "Consumidor " + (i + 1)).start();
        }
    }

    static class Produtor implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    int item = (int) (Math.random() * 100);
                    int bufferIndex = chooseBuffer(item);
                    buffers[bufferIndex].put(item);
                    System.out.println(Thread.currentThread().getName() + " produziu: " + item + " no buffer " + bufferIndex);
                    Thread.sleep(500); // Pausa para simular tempo de produção
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private int chooseBuffer(int item) {
            // Escolhe o buffer baseado no item (exemplo simples de escolha)
            return item % buffers.length;
        }
    }

    static class Consumidor implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    for (int i = 0; i < buffers.length; i++) {
                        Integer item = buffers[i].poll();
                        if (item != null) {
                            System.out.println(Thread.currentThread().getName() + " consumiu: " + item + " do buffer " + i);
                        }
                    }
                    Thread.sleep(500); // Pausa para simular tempo de consumo
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
