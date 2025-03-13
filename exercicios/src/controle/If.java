package controle;

import java.util.Scanner;

public class If {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
				
		System.out.print("Informe a média: ");
		double media = entrada.nextDouble();
		
		if(media < 0 || media > 10.0)
			System.out.println("Média Inválida!");
		else if(media <= 4.5)
			System.out.println("Reprovado!");
		else if(media < 7.0)
			System.out.println("Recuperação!");
		else if(media <= 10.0)
			System.out.println("Aprovado!");
		else
			System.out.println("Erro.");
		
				
		entrada.close();
	}
}
