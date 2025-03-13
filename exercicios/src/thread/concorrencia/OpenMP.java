package thread.concorrencia;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OpenMP {
	static final int tamanho = 100_000_000;
    static final long[] vetor = new long[tamanho];
    static int Quant_Threads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
    	Arrays.fill(vetor, 1);
    	
    	for (int i = 0; i < 2; i++) {
    		tempo(OpenMP::SomaOpenMP);
        }
    	
    	double somaTempos = 0;
    	int execucoes = 30;
        double[] tempos = new double[execucoes];
    	
        System.out.printf("Tempo de execucao Paralelo(OpenMP):\n");
        for (int i = 0; i < execucoes; i++) {
        	double tempoOpenMP = tempo(OpenMP::SomaOpenMP);
        	tempos[i] = tempoOpenMP;
        	somaTempos += tempoOpenMP;
        	System.out.printf("%d - %.7f segundos \n", i+1, tempoOpenMP);
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

    static long SomaOpenMP() {
        ExecutorService exec = Executors.newFixedThreadPool(Quant_Threads);
        List<Future<Long>> resultado = new ArrayList<>();
        int fracao = tamanho / Quant_Threads;

        for (int i = 0; i < Quant_Threads; i++) {
            int inicio = i * fracao;
            int fim = (i == Quant_Threads-1) ? tamanho : inicio + fracao;
            resultado.add(exec.submit(new Callable<Long>() {
                public Long call() {
                    long soma = 0;
                    for (int j = inicio; j < fim; j++) {
                        soma += vetor[j];
                    }
                    return soma;
                }
            }));
        }

        long soma = 0;
        for (Future<Long> result : resultado) {
            try {
                soma += result.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        exec.shutdown();
        return soma;
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

