package fundamentos.fundamentosfinal;

import java.util.Date;

public class Volta {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// lembrando um comentário simples
		/* lembrando um comentário com mais de uma linha.
		 * isso mesmo, mais de uma linha!
		 */
		System.out.println("lembrando o meu primeiro programa!");
		System.out.println("Não é meu primeiro programa em Java!");
		final double PI = 3.14159;
		
		final double DIV_FORMULA = 5/9;
		final double Div_FORMULA = 5.0/9;

		// alt + (^ ou v) move uma linha de comando
		// ctrl + alt + (^ ou v) duplica a linha de comando
        // ctrl + / transforma a linha em comentário
		// shift + alt + 'A' edita multiplas linhas
		// ctrl + 'd' deleta a linha
		// alt +shift + 'r' edita o nome da variável em todos os locais.
        // ctrl + shift + 'o' organiza os imports
	    // crtl + '1' sugere algumas alterações
		// crtl + shift = 'f' faz a indentação automática.
		// alt + shift + 's' abre o Source.
		// Ctrl + shift + 't' pesquisar em todas as classes.
	    // Alt + shift + 'z' envolva com - try/catch
		
		var b = 5; // declaração da váriavel por inferência
				  // Obrigatório declarar e inicializar a variável no mesmo comando
		
		String s = "Bom dia X";
		System.out.println(s.toUpperCase());
		System.out.println("José".toUpperCase());
		System.out.println(s = s.replace("X", "José"));
		System.out.println(s.concat(" !!!"));
		String y = "Boa noite Y"
				.replace("Y", "Senhora")
				.toLowerCase()
				.concat("!!");
		System.out.println(y);
		
		System.out.println("Olá pessoal".charAt(0));
		System.out.println(s.length());
		System.out.println(s.startsWith("Bom"));
		System.out.println(s.endsWith("JOSÉ"));
		System.out.println(s.equals("BOM DIA JOSÉ"));
		System.out.println(s.equalsIgnoreCase("BOM DIA JOSÉ"));
		
		var nome = "José";
		var sobrenome = "Wynder";
		var idade = 18;
		var salario = 12345.987F;
		
		System.out.println("Nome: " + nome + 
				"\nSobrenome: " + sobrenome + 
				"\nIdade: " + idade + 
				"\nSalário: " + salario);
		
		System.out.printf("\nO senhor %s %s tem %d anos e ganha %.2f",
				nome, sobrenome, idade, salario);
		
		// Utilizando String.format para passar os valores váriaveis para uma String.
		String frase = String.format("%nO senhor %s %s tem %d anos e ganha %.2f",
				nome, sobrenome, idade, salario);
		System.out.println(frase);
		
		// \n e %n servem como quebra de linha.
		
		// Scanner nome_scanner = new Scanner(System.in);
			// Captura dados da entrada de dados(teclado).
		//nome_scanner.close;
			// Fecha o Scanner para enconomizar processamento.
		
//		Scanner entrada = new Scanner(System.in);
//		
//		System.out.println("Qual seu nome? ");
//		String nome_scanner = entrada.nextLine();
//		
//		System.out.println("Qual sua idade:");
//		byte idade_scanner = entrada.nextByte();
//		//nome_scanner.nextTIPO_DE_DADOS();
//		entrada.close();
//		System.out.printf("%s tem %d anos", nome_scanner, idade_scanner);
		
		/*
		Scanner teclado = new Scanner(System.in);
		 
	    System.out.print("Qual a sua idade? ");
	    int idade = teclado.nextInt();
	    System.out.print("Qual o seu nome? ");
	    String nome = teclado.nextLine();
	    System.out.print("Qual o seu sobrenome? ");
	    String sobrenome = teclado.nextLine();
	 
	    teclado.close();
		 */
		
		// O código pula a entrada <nome> porque o .nextInt() deixar um \n para trás.
		// O mesmo ocorre com .nextDouble().
		// Para resolver utilize um .nextLine() após o .nextInt() ou .nextDouble().
		
		/*
		Scanner teclado = new Scanner(System.in);
		 
	    System.out.print("Qual a sua idade? ");
	    int idade = teclado.nextInt();
	    teclado.nextLine(); //lê o "\\\\n" que o teclado.nextInt() deixa para trás.
	    System.out.print("Qual o seu nome? ");
	    String nome = teclado.nextLine();
	    System.out.print("Qual o seu sobrenome? ");
	    String sobrenome = teclado.nextLine();
	 
	    teclado.close();
		 */
		
		Byte by = 10;
		Short sh = 100;
		Integer i = 10000;
		Long l = 100000L;
		
		System.out.println("\n" + by.toString());
		System.out.println(sh.byteValue());
		System.out.println(i * 3);
		System.out.println(i / 3);
		
		Float f = 123.10F;
		System.out.println(f);
		Double d = 1234.5678;
		System.out.println(d);
		
		Boolean bo = Boolean.parseBoolean("true");
		System.out.println(bo);
		System.out.println(bo.toString().toUpperCase());
		
		Character c = '#'; // char
		System.out.println(c + "...");
		
		double cast_a = 1; // implícita
		System.out.println(cast_a);
		float cast_b = (float) 1.123456788888; // explícita (CAST)
		System.out.println(cast_b);
		int cast_c = 140;
		byte cast_d = (byte) cast_c; // explícita (CAST)
		System.out.println(cast_d);
		double cast_e = 1.9999999;
		int cast_f = (int) cast_e; // explícita (CAST)
		System.out.println(cast_f);
		
		// Convertendo número para string.
		
		Integer num1 = 100000;
		System.out.println(num1.toString().length());
		
		int num2 = 100000;
		System.out.println(Integer.toString(num2).length());
		
		System.out.println(("" + num1).length());
		System.out.println(("" + num2).length());
		
		// Convertendo string para número.
		
//		String valor1 = JOptionPane.showInputDialog
//				("Digite o primeiro número");
//		String valor2 = JOptionPane.showInputDialog
//				("Digite o segundo número");
//		
//		System.out.println(valor1 + valor2);
//		
//		double numero1 = Double.parseDouble(valor1);
//		double numero2 = Double.parseDouble(valor2);
//		
//		double soma = numero1 + numero2;
//		System.out.println("Soma é " + soma);
//		System.out.println("Média é " + soma / 2);
		
		int aa = 2;
		int bb = (int)Math.pow(aa, 3); // Math.pow faz potenciação.
		System.out.println(bb);
		
		double media = 5.0;
		String resultadoParcial = media <= 5.0 ? "reprovado." : "em recuperação."; // Operador Ternário
		String resultadoFinal = media >= 7.0 ? "aprovado." : resultadoParcial;
		
		System.out.println("O aluno está " + resultadoFinal);
		
		System.out.println("2" == "2");
		
		String s1 = new String("2");
		System.out.println("2" == s1);
		System.out.println("2".equals(s1));
		
//		Scanner entrada1 = new Scanner(System.in);
//		
//		String s2 = entrada1.next();
//		System.out.println(s2);
//		System.out.println("2" == s2.trim()); // .trim() remove os espaço em branco.
//		System.out.println("2".equals(s2.trim()));
//		
//		entrada1.close();
		
		// JDK = Java Develoment Kit - Desenvolvedor
		// JRE = Java Runtime Enviroment - Usuário
		
		//Locale.setDefault(new Locale("en", "US")); // Para utilizar "." no lugar de "," em número com ponto flutuante.
		
		Date dt = new Date();
		String ano = dt.toString();
		int aux = ano.length();
		System.out.println(ano.substring(aux-4, aux)); // .substring captura uma sequência de caracteres pela sua posição na string.
		
		
		// Gera números aleatórios.
		
		int numeroInt = (int)(Math.random() * 100);
		System.out.println("Numero aleatrio (Int): " + numeroInt);
		
		//Gerando um número de ponto flutuante aleatório entre 0.0 e 1.0
		
		double numeroDouble = Math.random();
		System.out.println("Numero aleatorio (double): " + numeroDouble);
		
		
		// Gere espaços variáveis no print
		
		// Texto com recuo de 10 caracteres
		String text = "Texto com recuo de 10 caracteres.";
		int indentation = 10;
		
		// verifica se o comprimento do texto é maior do que o recuo
		if (text.length() > indentation) {
			// Imprime os espaços necessários para o recuo
			System.out.print(" ".repeat(indentation));
			// Imprime o texto a partir do recuo
			System.out.println(text.substring(indentation));
		} else {
			// Se o texto for menor ou igual ao recuo, imprime o texto normalmente
			System.out.println(text);
		}
		
		
		
		
	}
}
