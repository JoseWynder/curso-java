package controle.controlefinal;

public class ExerciciosEstruturasDeControle {
	public static void main(String[] args) {
		
	// EXERCÍCIO 1.	
		
//		float num = 0;
//		System.out.println("\nSAIR [-1]\n");
//		Scanner entrada = new Scanner(System.in);
//		
//		do {
//		System.out.print("Digite um número: ");
//		num = entrada.nextFloat();
//		
//		if(num > 0 && num < 10) {
//			System.out.print("O número está ENTRE 0 e 10 e ");
//		} else {
//			System.out.print("O número não está ENTRE 0 e 10 e ");
//		}
//		if(num % 2 == 0) {
//			System.out.println("é par!\n");
//		} else {
//			System.out.println("não é par!\n");
//		}
//		
//		} while(num != -1);
//		
//		entrada.close();

	// EXERCÍCIO 2.	
		
//		Date data = new Date();
//		String stringData = data.toString();
//		int aux = stringData.length();
//		int ano = Integer.parseInt(stringData.substring(aux-4, aux));
//		boolean verificador;
//		if(ano % 4 == 0) {
//			if(ano % 100 == 0) {
//				if(ano % 400 == 0) {
//					verificador = true;
//				} else { verificador = false; }
//			} else { verificador = true; }
//		} else { verificador = false; }
//		
//		if(verificador) {
//			System.out.println("O ano atual (" + ano + ") é Bissexto!");
//		} else {
//			System.out.println("O ano atual (" + ano + ") não é Bissexto!");
//		}
		
	// EXERCÍCIO 3.
		
//		Scanner entrada = new Scanner(System.in);
//		
//		float nota1, nota2, media;
//		boolean verificador;
//		
//		do {
//		System.out.print("Digite a primeira nota: ");
//		nota1 = entrada.nextFloat();
//		System.out.print("Digite a segunda nota: ");
//		nota2 = entrada.nextFloat();
//		media = (nota1 + nota2) / 2;
//		verificador = (nota1 >= 0 && nota1 <= 10) && (nota2 >= 0 && nota2 <= 10);
//		
//		if(verificador) {
//		if(media >= 7.0) {
//			System.out.println("Nota " + media + ", Aprovado!");
//		} else if(media > 4.0) {
//			System.out.println("Nota " + media + ", Recuperação!");
//		} else {
//			System.out.println("Nota " + media + ", Reprovado!");
//		}
//		} else {
//			System.out.println("Nota Inválida!\n");
//		}
//		} while(!verificador);
//		
//		entrada.close();
	
	// EXERCÍCIO 4.
	
//		Scanner entrada = new Scanner(System.in);
//
//		boolean verificador = true;
//		
//		System.out.print("Digite um número: ");
//		long primo = entrada.nextLong();
//		if(primo == 1) {
//			verificador = false;
//		} else if(primo == 2) {
//			verificador = true;
//	 	} else if(primo == 3) {
//			verificador = true;
//		} else if(primo % 2 == 0) {
//			verificador = false;
//		} else if(primo % 3 == 0) {
//			verificador = false;
//		} else {
//			for(int c = 5; c <= primo/c; c += 6) {
//				if(primo % c == 0 || (primo % (c + 2) == 0)) {
//					verificador = false;
//					break;
//				}
//			}
//		}
//		if(verificador) {
//			System.out.println("O número digitado é Primo!");
//		} else {
//			System.out.println("O número digitado não é Primo!");
//		}
//		entrada.close();
		
	// EXERCÍCIO 5.
		
		
//		Scanner entrada = new Scanner(System.in);
//
//		Boolean verificador = true;
//		
//		System.out.print("Digite um número: ");
//		long primo = entrada.nextLong();
//		if(primo == 1) {
//			verificador = false;
//		} else if(primo == 2) {
//			verificador = true;
//		} else if(primo % 2 == 0) {
//			verificador = false;
//		} else if(primo % 3 == 0) {
//			verificador = false;
//		} else {
//			for(int c = 5; c <= primo/c; c += 6) {
//				if(primo % c == 0 || (primo % (c + 2) == 0)) {
//					verificador = false;
//					break;
//				}
//			}
//		}
//		switch(verificador.toString()) {
//		case "true":
//			System.out.println("O número digitado é Primo!");
//			break;
//		case "false":	
//			System.out.println("O número digitado não é Primo!");
//			break;
//		}
//		entrada.close();
		
	// EXERCÍCIO 6.
		
//		int aleatorio, c, chute;
//		c = 10;
//		aleatorio = (int)(Math.random() * 1000);
//		Scanner entrada = new Scanner(System.in);
//		do {
//			System.out.println("\nTENTATIVAS RESTANTES: " + c);
//			c--;
//			System.out.print("Chute um número: ");
//			chute = entrada.nextInt();
//			if(chute != aleatorio && c == 0) {
//				System.out.println("\n         Você errou! :( ");
//			} else if(chute < aleatorio) {
//				System.out.println("O número é maior!");
//			} else if(chute > aleatorio){
//				System.out.println("O número é menor!");
//			} else {
//				System.out.println("\n     Parabêns, você acertou!");
//			}
//		} while(c >= 1 && !(chute == aleatorio));
//		entrada.close();
//		System.out.println("----------------------------------");
//		System.out.println("      O NÚMERO ERA: " + aleatorio + "!");
		
	// EXERCÍCIO 7.

//		float num = 0;
//		float soma = 0;
//		Scanner entrada = new Scanner(System.in);
//		do {
//			System.out.print("Digite números para somar: ");
//			num = entrada.nextFloat();
//			if(num >= 0){
//			soma += num;
//			System.out.printf("Soma = %.2f\n", soma);
//			}
//		}while(num >= 0);
//		entrada.close();
//		System.out.printf("\nSoma final = %.2f", soma);
//		System.out.println("\nENCERRANDO... ");
	
	// EXERCÍCIO 8.
		
//		Scanner entrada = new Scanner(System.in);
//
//		System.out.print("Escreva uma palavra: ");
//		String palavra = entrada.next();
//		System.out.println();
//		
//	for(int c = 0; c < palavra.length(); c++) {
//		System.out.println(" " + palavra.toUpperCase().charAt(c));
//	}
//
//		entrada.close();
		
	//EXERCÍCIO 9.
		
//		int num = 0;
//		int maior = 0;
//		Scanner entrada = new Scanner(System.in);
//		for(int c = 1; c <= 10; c++) {
//			System.out.print("Digite o " + c + "° valor: ");
//			num = entrada.nextInt();
//			if(maior < num) {
//				maior = num; 
//			}
//		}
//		entrada.close();
//		System.out.println("\nO maior número digitado foi: " + maior);
		
	}
}