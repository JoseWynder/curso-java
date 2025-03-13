package controle;

import java.util.Scanner;

public class DesafioWhile {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);

		int c;
		float nota, somaNota, media;
		somaNota = 0;
		nota = 0;
		c = 1;
		do {
			System.out.print("Nota " + c + "° aluno: ");
			nota = entrada.nextFloat();
			if(nota >= 0 && nota <= 10) {
				++c;
				somaNota += nota;
			} else if(nota != -1){
				System.out.printf("Nota inválida!%n\n");
			}
		} while(nota != -1);
		
		entrada.close();
		
		if(c == 1) {
			media = somaNota / c;
		} else {
			media = somaNota / (c-1);
		}
		System.out.printf("A média da turma foi: %.2f", media);
		
	}
}
