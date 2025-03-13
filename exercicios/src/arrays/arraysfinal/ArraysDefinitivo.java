package arrays.arraysfinal;

import java.util.Arrays;
import java.util.Scanner;


public class ArraysDefinitivo {
	
	public static void main(String[] args) {
		
		// Array é uma estrutura estática
		// Array é homogêneo (tipo único)
		// Array é um objeto = array tem atributos e comportamentos
		// O Array é indexado. Possui índice próprio iniciado em 0;
		
		// ESTRUTURA DE UM ARRAY ( tipo[] nome = new tipo[tamanho]; )
		
		/* Notação ponto não ira funcionar para tipos primitivos
		 * Demonstração: 
		 * 
		 * double[] d = new double[5];
		 * 
		 * d.length --> funciona porque você está acessando um objeto (Array)
		 * 
		 * d[1].length --> não funciona porque você está acessando um tipo primitivo (double)
		 */
		
		
		/*
		 *                 -------------
		 * Vetor(4) - >    |0 |1 |2 |3 |
		 *                 -------------
		 *            
		 *           
		 * Vetor = []
		 * 
		 *                  -------------
		 *                  |0 |1 |2 |3 |
		 *                  -------------
		 * Matriz(3x4) - >  |4 |5 |6 |7 | ( não existe uma estrutura multidimencional como matriz em Java )
		 *                  -------------
		 *                  |8 |9 |10|11|
		 *                  -------------
		 *             
		 *             
		 *               ----------------- 
		 *              |                 |
		 * Matriz(3x4)  |  -------------  |
		 *  em Java ->  |  |0 |1 |2 |3 |  |
		 *              |  -------------  |
		 *              |                 |
		 *               ----------------- 
		 *              |                 |
		 *              |  -------------  |
		 *              |  |4 |5 |6 |7 |  |
		 *              |  -------------  |
		 *              |                 |
		 *               ----------------- 
		 *              |                 |
		 *              |  -------------  |
		 *              |  |8 |9 |10|11|  |
		 *              |  -------------  |
		 *              |                 |
		 *               -----------------
		 *               
		 *               
		 * Essa forma de representação é basicamente um Array de 3 posições
		 *  com outro Array de 4 posições dentro de cada um dos Arrays.
		 *  
		 * Na prática funciona da mesma maneira.
		 * 
		 * Matriz = [][]...
		 * 
		 * 
		 * 
		 */
		
		double[] notasAlunoA = new double[2]; // Vetor
		
		notasAlunoA[0] = 3;
		notasAlunoA[1] = 1.2;
		
		final double notaArmazenada = 5.1;
		double[] notasAlunoB = { 8.9, notaArmazenada}; // Inicializando um Array com valores literais.
		
		/* Imprimindo todo o Array:
		 * 
		 * System.out.println(notasAlunoA); - > Não funciona!
		 *  Ao utilizá-lo ele imprime um identificador que é composto pelo tipo de array
		 *  seguido por um "@" e um código hash hexadecimal (derivado do hashCode).
		 * 
		 * A forma correta seria utilizar a função toString do objeto Arrays de java.util
		 * 
		 * System.out.println(Arrays.toString(notasAlunoA)); // < - forma correta
		 * Ao acessar o Array antes de setar qualquer valor ele será inicializado com o valor padrão do seu tipo
		*/
		
		
		// System.out.println(notasAlunoA[notasAlunoA.length - 1]); Pegar a ultima nota
		
		
		for(int i = 0; i < notasAlunoA.length; i++) { 
			System.out.print(notasAlunoA[i] + " ");
		} // Utilizando o for() para percorrer o Array conforme o que for conveniente.
		
		System.out.println();
		
		for(double notaAlunoB : notasAlunoB) { // Foreach
			System.out.print(notaAlunoB + " ");
		} // Utiliza-se o Foreach para percorrer um Array do inicio ao fim.
		
		// System.out.println(totalAlunoA / notasAlunoA.length); 
		    // Fazer a média de forma adaptada para qualquer tamanho de Array.
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf("\n\nQuantos alunos? ");
		int quantAlunos = entrada.nextInt();
		
		System.out.print("Quantas notas por aluno? ");
		int quantNotas = entrada.nextInt();
		
		
		double[][] notasDaTurma = new double[quantAlunos][quantNotas]; // Matriz 
			// TEORICAMENTE (quantAlunos = linha) e (quantNotas = coluna)
		
		
		double total = 0;
		for (int a = 0; a < notasDaTurma.length; a++) { 
			// Vai repetir a quantidade de alunos da Matriz. notasDaTurma.length = quantAlunos
			for (int n = 0; n < notasDaTurma[a].length; n++) { 
				// Vai repetir a quantidade de notas de cada aluno. notasDaTurma[a].length = quantNotas
				
				System.out.printf("Informe a nota %d do aluno %d: ", n+1, a+1);
				notasDaTurma[a][n] = entrada.nextDouble();
				total += notasDaTurma[a][n];
			}
		}
			
		
		entrada.close();
		System.out.println();
		
		System.out.println(Arrays.deepToString(notasDaTurma)); // Método para imprimir uma Matriz 
		 // (Arrays.toString(notasDaTurma)) não funcina com Arrays multidimensionais.
		
		double media = total != 0 ? total / (quantAlunos * quantNotas) : 0; // Caso "quantAlunos" ou/e "quantNotas" sejam <= 0;
		System.out.printf("\nMédia da turma é %.2f\n\n", media);
		
		for(double[] notasDoAluno : notasDaTurma) {
			System.out.println(Arrays.toString(notasDoAluno)); 
				// Imprime a Matriz manualmente de forma em que cada linha seja colocada em uma nova linha (Uma embaixo da outra).
		}
		
		
	}
}
