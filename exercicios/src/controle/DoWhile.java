package controle;

import java.util.Scanner;

public class DoWhile {
	public static void main(String[] args) {
		
		
		Scanner entrada = new Scanner(System.in);
		
		String texto = "";
		do {
			System.out.println("Você precisa falar "
					+"as palavras mágicas...");
			System.out.print("Quer sair? ");
			texto = entrada.nextLine();
		} while (!"Por favor".equalsIgnoreCase(texto.trim()));
		
		entrada.close();
		
		System.out.println("Obrigado!");

	}
}
