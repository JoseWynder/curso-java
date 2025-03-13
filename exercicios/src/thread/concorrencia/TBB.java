package thread.concorrencia;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings({"serial", "resource"})
public class TBB {
	static final int tamanho = 100_000_000;
    static final long[] vetor = new long[tamanho];
    static final int PART_MAX = tamanho/4;

    public static void main(String[] args) {
    	Arrays.fill(vetor, 1);
    	
    	for (int i = 0; i < 2; i++) {
    		tempo(TBB::SomaTBB);
        }
    	
    	double somaTempos = 0;
    	int execucoes = 30;
        double[] tempos = new double[execucoes];
    	
        System.out.printf("Tempo de execucao Paralelo(TBB):\n");
        for (int i = 0; i < execucoes; i++) {
        	double tempoTBB = tempo(TBB::SomaTBB);
        	tempos[i] = tempoTBB;
        	somaTempos += tempoTBB;
        	System.out.printf("%d - %.7f segundos \n", i+1, tempoTBB);
        }
        
        double mediaTempo = somaTempos / execucoes;
        System.out.printf("\nMedia: %.7f segundos \n", mediaTempo);
        
        double desvioPadrao = desvioPadrao(tempos, mediaTempo);
        System.out.printf("Desvio padrao: %.7f segundos \n", desvioPadrao);
    }

    static double tempo(Runnable metodo) {
        Instant inicio = Instant.now();
        metodo.run();
        Instant fim = Instant.now();
        Duration duracao = Duration.between(inicio, fim);
        return duracao.toNanos()/1_000_000_000.0;
    }

    static long SomaTBB() {
    	long soma = new ForkJoinPool().invoke(new SomaTask(vetor, 0, tamanho));
        return soma;
    }

    static class SomaTask extends RecursiveTask<Long> {
        private long[] vetor;
        private int inicio, fim;

        SomaTask(long[] vetor, int inicio, int fim) {
            this.vetor = vetor;
            this.inicio = inicio;
            this.fim = fim;
        }

        @Override
        protected Long compute() {
            if (fim - inicio <= PART_MAX) {
                long soma = 0;
                for (int i = inicio; i < fim; i++) {
                    soma += vetor[i];
                }
                return soma;
            } else {
                int meio = (inicio + fim) / 2;
                SomaTask esquerda = new SomaTask(vetor, inicio, meio);
                SomaTask direita = new SomaTask(vetor, meio, fim);
                invokeAll(esquerda, direita);
                return esquerda.join() + direita.join();
            }
        }
    }
    
    static double desvioPadrao(double[] tempos, double media) {
        double somaQuadradosDiferenca = 0;
        int n = tempos.length;

        for (double tempo : tempos) {
            somaQuadradosDiferenca += Math.pow(tempo - media, 2);
        }

        return Math.sqrt(somaQuadradosDiferenca / (n - 1));
    }
}



