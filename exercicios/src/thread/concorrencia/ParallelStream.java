package thread.concorrencia;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ParallelStream {
	static final int tamanho = 100_000_000;
    static final long[] vetor = new long[tamanho];

    public static void main(String[] args) {
    	Arrays.fill(vetor, 1);
    	
    	for (int i = 0; i < 2; i++) {
    		tempo(ParallelStream::SomaParallelStream);
        }
    	
    	double somaTempos = 0;
    	int execucoes = 30;
        double[] tempos = new double[execucoes];
    	
        System.out.printf("Tempo de execucao Paralelo(ParallelStream):\n");
        for (int i = 0; i < execucoes; i++) {
        	double tempoParallelStream = tempo(ParallelStream::SomaParallelStream);
        	tempos[i] = tempoParallelStream;
        	somaTempos += tempoParallelStream;
        	System.out.printf("%d - %.7f segundos \n", i+1, tempoParallelStream);
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

    static long SomaParallelStream() {
    	long soma = Arrays.stream(vetor).parallel().sum();
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



