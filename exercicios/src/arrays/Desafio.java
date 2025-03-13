package arrays;

import java.util.Scanner;

public class Desafio {
	public static void main(String[] args) {
		
		int quantNotas;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Quantas notas serão inseridas? ");
		quantNotas = entrada.nextInt();

		double[] nota = new double[quantNotas];
		
		for(int i = 0; i < quantNotas; i++) {
			System.out.print(i+1 + "° Nota: ");
			nota[i] = entrada.nextDouble();
		}
		
		entrada.close();

		double soma = 0;
		for(double notas : nota) {
			soma += notas;
		}
		
		System.out.println("Média aluno: " + soma / quantNotas);
		
	}
}
