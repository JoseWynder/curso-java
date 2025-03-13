package fundamentos.operadores;

public class AnotacoesTime {
	public static void main(String[] args) {
		// Teste eficiência
		
				int numero = 1000000; // Número para verificar a eficiência
		        long startTime, endTime;
		        
		        // Primeira implementação: (X)
		        startTime = System.nanoTime();
		        testarEficiencia1(numero);
		        endTime = System.nanoTime();
		        System.out.println("Tempo de execução para (X): " + (endTime - startTime) + " nanossegundos");

		        // Segunda implementação: (Y)
		        startTime = System.nanoTime();
		        testarEficiencia2(numero);
		        endTime = System.nanoTime();
		        System.out.println("Tempo de execução para (Y): " + (endTime - startTime) + " nanossegundos");
		        
		    }
			// Primeira implementação
			public static void testarEficiencia1(int numero) {
				
				// Faz algo aqui...
			}
			
			// Segunda implementação
			public static void testarEficiencia2(int numero) {
				
				// Faz algo aqui...
			}
}
