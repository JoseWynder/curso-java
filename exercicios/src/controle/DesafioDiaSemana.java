package controle;

import java.util.Scanner;

public class DesafioDiaSemana {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o dia da semana: ");
		String diaSemanaUser = entrada.nextLine();
		
		entrada.close();
		
		diaSemanaUser = diaSemanaUser.trim().toLowerCase()
				.replace("ç", "c")
				.replace("á", "a");
		
		String diaSemanaDev = diaSemanaUser.replace("-", "").replace("feira", "");

		if("Domingo".equalsIgnoreCase(diaSemanaUser)) {
			System.out.println("1");
		} else if("Segunda".equalsIgnoreCase(diaSemanaDev)) {
			System.out.println("2");
		} else if("Terca".equalsIgnoreCase(diaSemanaDev)) {
			System.out.println("3");
		} else if("Quarta".equalsIgnoreCase(diaSemanaDev)) {
			System.out.println("4");
		} else if("Quinta".equalsIgnoreCase(diaSemanaDev)) {
			System.out.println("5");
		} else if("Sexta".equalsIgnoreCase(diaSemanaDev)) {
			System.out.println("6");
		} else if("Sabado".equalsIgnoreCase(diaSemanaUser)) {
			System.out.println("7");
		} else {
			System.out.println("Inválido!");
		}
		
	}
}
