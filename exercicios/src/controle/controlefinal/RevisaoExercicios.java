package controle.controlefinal;

public class RevisaoExercicios {
	public static void main(String[] args) {
		
		// EXERCÍCIO 1.	
		
//		float num;
//		System.out.println("SAIR [-1]");
//		
//		Scanner entrada = new Scanner(System.in);
//		
//		do {
//			System.out.print("\nDigite um número: ");
//			num = entrada.nextFloat();
//			if (num > 0 && num < 10) {
//				System.out.print("O número está ENTRE 0 e 10 ");
//			} else {
//				System.out.print("O número não está ENTRE 0 e 10 ");				
//			}
//			if (num % 2 == 0) {
//				System.out.println("e é par!");
//			} else {
//				System.out.println("e não é par!");
//			}
//			
//		}while(num != -1);
//		
//		entrada.close();
		
		// EXERCÍCIO 2.	
		
//		Date date = new Date();
//		String data = date.toString();
//		byte aux = (byte)data.length();
//		short ano = Short.parseShort(data.substring(aux-4, aux));
//		boolean bi;
//
//		if (ano % 4 == 0) {
//			if (ano % 100 == 0){
//				if (ano % 400 == 0){
//					bi = true;
//				} else { bi = false; }
//			} else { bi = true; }
//		} else { bi = false; }
//		
//		if (bi) {
//			System.out.println("O ano atual (" + ano + ") é Bissexto!");
//		} else {
//			System.out.println("O ano atual (" + ano + ") não é Bissexto!");
//		}
		
		// EXERCÍCIO 3.	
		
//		float n1, n2, media;
//		boolean aux;
//		
//		Scanner entrada = new Scanner(System.in);
//		
//		do {
//			System.out.print("Digite a primeira nota: ");
//			n1 = entrada.nextFloat();
//			System.out.print("Digite a segunda nota: ");
//			n2 = entrada.nextFloat();
//			aux = (n1 >= 0) && (n1 <= 10) && (n2 >= 0) && (n2 <= 10);
//			if (!aux) {
//				System.out.println("Nota inválida!\n");
//			}
//		}while(!aux);
//		
//		entrada.close();
//		
//		media = (n1+n2)/2;
//		System.out.print("Nota " + media + ", ");
//		if (media >= 7.0) {
//			System.out.println("Aprovado!");
//		} else if (media > 4.0){
//			System.out.println("Recuperação!");
//		} else {
//			System.out.println("Reprovado!");
//		}
		
		// EXERCÍCIO 4.	
		
//		Scanner entrada = new Scanner(System.in);
//		
//		System.out.print("Digite um número: ");
//		long num = entrada.nextLong();
//		
//		entrada.close();
//		
//		
//		boolean primo;
//		
//		externo: if (num == 1) {
//			primo = false;
//		} else if (num == 2) {
//			primo = true;
//		} else if (num % 2 == 0) {
//			primo = false;
//		} else {
//			for(long divisor = 3; divisor <= (num/divisor); divisor += 2) {
//				if (num % divisor == 0) {
//					primo = false;
//					break externo;
//				}
//			}
//			primo = true;
//		}
//		
//		if(primo) {
//			System.out.println("O número digitado (" + num + ") é Primo!");
//		} else {			
//			System.out.println("O número digitado (" + num + ") não é Primo!");
//		}
		
		// EXERCÍCIO 5.
		
//		Scanner entrada = new Scanner(System.in);
//		
//		System.out.print("Digite um número: ");
//		long num = entrada.nextLong();
//		
//		entrada.close();
//		
//		
//		boolean primo;
//		
//		externo: switch(Long.toString(num)) {
//		case "1":
//			primo = false;
//			break;
//		case "2":
//			primo = true;
//			break;
//		default:
//			if (num % 2 == 0) {
//				primo = false;
//			} else {
//			for(long divisor = 3; divisor <= (num/divisor); divisor += 2) {
//				if (num % divisor == 0) {
//					primo = false;
//					break externo;
//				}
//			}
//			primo = true;
//			}
//		}
//		
//		switch(Boolean.toString(primo)) {
//			case "true":
//				System.out.println("O número digitado (" + num + ") é Primo!");
//				break;
//			case "false":	
//				System.out.println("O número digitado (" + num + ") não é Primo!");
//		}
		
		// EXERCÍCIO 6.
		
//		byte cont = 10;
//		short chute;
//		short num = (short)(Math.random() * 1000);
//		System.out.println("\n - Acerte o número de 0 a 1000 - ");
//		
//		Scanner entrada = new Scanner(System.in);
//		
//		do {
//			System.out.println("\nTENTATIVAS RESTANTES: " + cont);
//			System.out.print("Chute um número: ");
//			chute = entrada.nextShort();
//			if (chute > num) {
//				System.out.println("O número é menor!");
//			} else if (chute < num){
//				System.out.println("O número é maior!");
//			}
//			cont--;
//		} while(cont != 0 && chute != num);
//		
//		entrada.close();
//		
//		String tamanho = "--------------------------------";
//		byte aux = (byte)tamanho.length();
//		
//		if (chute != num) {
//			System.out.print("\n\n" + " ".repeat(aux/2-7));
//			System.out.println("Você errou! :(");
//		} else {
//			System.out.print("\n\n" + " ".repeat(aux/2-11));
//			System.out.println("Parabêns, você acertou!");	
//		}
//		
//		System.out.println(tamanho);
//		System.out.print(" ".repeat(aux/2-9));
//		System.out.println("O NÚMERO ERA: " + num + "!");
		
		// EXERCÍCIO 7.
		
		
//		System.out.println("ENCERRAR [0]");
//		float num;
//		float soma = 0;
//		Scanner entrada = new Scanner(System.in);
//		
//		do {
//			System.out.print("Digite números para somar: ");
//			num = entrada.nextFloat();
//			if (num != 0) {
//				soma += num;
//				System.out.printf("Soma = %.2f\n", soma);
//			}
//		} while (num != 0);
//
//		entrada.close();
//		
//		System.out.println("\nA soma final é " + soma);
//		System.out.println("ENCERRANDO...");
		
		// EXERCÍCIO 8.
		
//		Scanner entrada = new Scanner(System.in);
//		
//		System.out.print("Escreva uma palavra: ");
//		String palavra = entrada.next();
//		
//		int tamanho = palavra.length();
//		for(int c = 0; c < tamanho; c++) {
//			System.out.printf("\n %c", palavra.toUpperCase().charAt(c));
//		}
//		
//		entrada.close();
		
		// EXERCÍCIO 9.
		
//		float num;
//		float maior = 0;
//		byte c = 0;
//		
//		Scanner entrada = new Scanner(System.in);
//		
//		do {
//			System.out.print("Digite o " + (c+1) + "° valor: ");
//			num = entrada.nextFloat();
//			c++;
//			if (num > maior || c == 1) {
//				maior = num;
//			}
//		} while(c < 5);
//		
//		entrada.close();
//		
//		System.out.println("\nO maior número digitado foi: " + maior);
		

		
	}
}

