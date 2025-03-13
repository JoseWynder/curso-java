package controle;

import java.util.Scanner;

public class WhileIndeterminado {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String valor = "";
		
		while(!"sair".equalsIgnoreCase(valor)) {
			System.out.println("Você diz: ");
			valor = entrada.nextLine();
		}
		
		
		
		
		entrada.close();
	}
}
