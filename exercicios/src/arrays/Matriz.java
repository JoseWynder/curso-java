package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Matriz {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Quantos alunos? ");
		int quantAlunos = entrada.nextInt();
		
		System.out.print("Quantas notas por aluno? ");
		int quantNotas = entrada.nextInt();
		
		
		double[][] notasDaTurma = new double[quantAlunos][quantNotas];
		
		double total = 0;
		for (int a = 0; a < notasDaTurma.length; a++) {
			for (int n = 0; n < notasDaTurma[a].length; n++) {
				
				System.out.printf("Informe a nota %d do aluno %d: ", n+1, a+1);
				notasDaTurma[a][n] = entrada.nextDouble();
				total += notasDaTurma[a][n];
			}
		}
		System.out.println(notasDaTurma.length);
		System.out.println(notasDaTurma[0][0]);
		
		double media = total != 0 ? total / (quantAlunos * quantNotas) : 0;
		System.out.println("Média da turma é " + media);
		
		for(double[] notasDoAluno : notasDaTurma) {
			System.out.println(Arrays.toString(notasDoAluno));
		}
		
		entrada.close();
		
	}
}
