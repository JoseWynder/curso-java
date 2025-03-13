package controle;

import java.util.Scanner;

public class SwitchSemBreak {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);

		System.out.print("Qual sua faixa? ");
		String faixa = entrada.next();
		
		switch(faixa.toLowerCase()) {
		case "preta":
			System.out.println("Sei o Bassai-Dai...");
		case "marrom":
			System.out.println("Sei o Tekki Shodan");
		case "roxo":
			System.out.println("Sei o Heian Godan");
		case "verde":
			System.out.println("Sei o Heian Yodan");
		case "laranja":
			System.out.println("Sei o Heian Sandan");
		case "vermelha":
			System.out.println("Sei o Heian Nidan");
		case "amarela":
			System.out.println("Sei o Heian Shodan");
			break;
		default:
			System.out.println("Não sei nada");
		}
		entrada.close();
		
	}
}
