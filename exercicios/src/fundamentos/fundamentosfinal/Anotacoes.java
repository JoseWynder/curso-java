package fundamentos.fundamentosfinal;

import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Anotacoes {
	
	/**
	 * Essa classe representa... JAVADOC
	 * 
	 * @param José Wynder <@gmail.com>
	 * @since JDK1.0
	 * @see
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Uma setença de código termina com ;
		// Mais um comentário...
		// Fim
		System.out.println("Primeiro programa parte 1!");
		System.out.println("Primeiro programa parte 2!");
		/*
		 Linha 1
		 Linha 2
		 Linha 3...
		 */
		System.out.println("Fim"); // Aqui também funciona!
		System.out.println(); // Escreve na saída do sistema! Syso -> (ctrl + espaço)
	    final double PI = 3.14159; //<final> transforma a variavel em constante.
	    
	    // Nome de constante com letra maiuscula.
	    
	    final double DIV_FORMULA = 5/9; // Resultado da divisão inteiro.
	    final double Div_FORMULA = 5/9.0; // Resultado da divisão real.
	    
	    // Alt + (^ ou v) Move uma linha de comando.
	    // Ctrl + Alt + (^ ou v) Duplica a linha.
	    // Crtl + / Transforma a linha em comentário.
	    // Shift + Alt + 'A' entra no modo edição de multiplas linhas.
	    // Ctrl + 'd' deleta a linha.
	    // alt +shift + 'r' edita o nome da variável em todos os locais.
        // ctrl + shift + 'o' organiza os imports
	    // crtl + '1' sugere algumas alterações
	    // crtl + shift + 'f' faz a indentação automática.
	    // alt + shift + 's' abre o Source.
	    // Ctrl + shift + 't' pesquisar em todas as classes.
	    // Alt + shift + 'z' envolva com - try/catch
	    
	    var b = 5; // Declaração de variável por inferência.
	    		   // Obrigatório declarar e inicializar a variável na mesma linha.
	    
	    
	    String s = "Bom dia X";
	    System.out.println(s.toUpperCase()); // .toUpperCase() Coloca em maiúsculo os caracteres.
	    System.out.println("José".toUpperCase());
	    s = s.replace("X", "Senhora"); // .replace(oldChar, newChar) Substitui caracteres por outros.
		System.out.println(s);
		System.out.println(s.concat("!!!")); // .concat() Concatena.
		String y = "Boa noite Y"
				.replace("Y", "José")
				.toLowerCase()
				.concat("!!");
		System.out.println(y);
		// Tipos primitivos não tem o operador "."
		
		System.out.println("Olá pessoal".charAt(0)); // .charAt(int) Mostra o carácter na posição requerida.
		System.out.println(s.length()); // .length() Mostra o tamanho da String.
		System.out.println(s.startsWith("Bom")); // .startsWith("Bom") Verifica se a String começa com "Bom".
		System.out.println(s.endsWith("DIA")); // .endsWith("DIA") Verifica se a String termina com "DIA".
		System.out.println(s.equalsIgnoreCase("BOM DIA SENHORA")); // .equals() Verifica igualdade. 
					// .equalsIgnoreCase() Verifica a igualdade ignorando diferença de maiúscula e minúscula.
	
		
		var nome = "Pedro";
		var sobrenome = "Santos";
		var idade = 33;
		var salario = 12345.987F;
		
		// Utilizando print.
		System.out.println("Nome: " + nome + 
						"\nSobrenome: " + sobrenome + 
						"\nIdade: " + idade + 
						"\nSalario: " + salario);
		
		// Utilizando printf.
		System.out.printf("\nO senhor %s %s tem %d e ganha %.2f.",
				nome, sobrenome, idade, salario);
		
		// Utilizando String.format para passar os valores váriaveis para uma String.
		String frase = String.format("\nO senhor %s %s tem %d e ganha %.2f.",
				nome, sobrenome, idade, salario);
		System.out.println(frase);
		
		// \n e %n servem como quebra de linha.
		
		
		// Scanner teste = new Scanner(System.in); 
			// Scanner nome_scanner = new Scanner(System.in) captura dados da entrada de dados (teclado).
		// teste.close();	
			// Fecha o Scanner para economizar processamento.
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o seu nome: "); 
		String nome2 = entrada.nextLine(); // String variável = nome_scanner.nextLine(); Para String.
		
		System.out.print("Digite a sua idade: ");
		int idade2 = entrada.nextInt(); // String variável = nome_scanner.nextInt(); Para Int.
		// nome_scanner.nextTIPO_DE_DADO();
		entrada.close();
		System.out.printf("%s tem %d anos.", nome2, idade2);
		
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
		
		//Wrappers
		Byte by = 10;
		Short sh = 100;
		Integer i = 10000; // int
		Long l = 100000L;
		
		System.out.println("\n" + by.toString());
		System.out.println(sh.byteValue());
		System.out.println(i * 3);
		System.out.println(l / 3);
		
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
		
		Integer num1 = 10000;
		System.out.println(num1.toString().length());
		
		
		int num2 = 100000;
		System.out.println(Integer.toString(num2).length());
		
		
		System.out.println(("" + num1).length());
		System.out.println(("" + num2).length());
		
		// Convertendo string para número.
		
		String valor1 = JOptionPane.showInputDialog
				("Digite o primeiro número");
		String valor2 = JOptionPane.showInputDialog
				("Digite o segundo número");
		
		System.out.println(valor1 + valor2);
		
		double numero1 = Double.parseDouble(valor1);
		double numero2 = Double.parseDouble(valor2);
		
		double soma = numero1 + numero2;
		System.out.println("Soma é "+ soma);
		System.out.println("Média é "+ soma / 2);
		
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
//		System.out.println("2" == s2.trim());
//		System.out.println("2".equals(s2.trim()));
//		
//		entrada1.close();
		
		// JDK = Java Development Kit - Desenvolvedor
		// JRE = Java Runtime Environment - Usuário
		
		//Locale.setDefault(new Locale("en", "US")); // Para utilizar "." no lugar de "," para indicar número com ponto flutuante.
		
		Date dt = new Date();
		String ano = dt.toString();
		int aux = ano.length();
		System.out.println(ano.substring(aux-4, aux)); // .substring captura uma sequência de caracteres pela sua posição na string.
        
      //Gera números aleatórios.
        
        int numeroInt = (int)(Math.random() * 100);
        System.out.println("Número aleatório (Int): " + numeroInt);
        
        // Gerando um número de ponto flutuante aleatório entre 0.0 e 1.0
        double numeroDouble = Math.random();
        System.out.println("Número aleatório (double): " + numeroDouble);
        
        
      //Gera espaços variáveis no print
        
     // Texto com recuo de 10 caracteres
        String text = "Texto com recuo de 10 caracteres.";
        int indentation = 10;

        // Verifica se o comprimento do texto é maior do que o recuo
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
