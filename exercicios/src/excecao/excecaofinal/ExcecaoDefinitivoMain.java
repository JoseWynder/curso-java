package excecao.excecaofinal;

import java.util.Scanner;

import excecao.Aluno;

public class ExcecaoDefinitivoMain {

	public static void main(String[] args) {
		

		Scanner entrada = new Scanner(System.in);
		
		try {
			System.out.println(7 / 0 /* entrada.nextInt() */);
		} catch (Exception e) {
			/* O ideal é tratar o erro de uma forma mais expecífica.
			 * Tendo consciência de quais erros podem ocorrer no código.
			 * Mas eventualmente pode ser que o tipo de erro não interfira tanto já que
			 * independente do tipo de erro, você só vai enviar uma mensagem para o usuário.
			 */
			
//			e.printStackTrace(); // imprime a pilha de execução e diz em que ponto 
				//  ocorreu o problema. Em que ponto essa exceção foi lançada.
			System.out.println("Ocorreu o erro: " + e.getMessage());
		} finally { // É executado independente se tiver erro ou não.
			System.out.println("Finally #01...");
		}
		
		try { // Não é necessário ter um catch associado.
//			System.out.println(7 / 0);
		} finally {
			// Mesmo sem o erro ser tratado, o programa primeiro executa o
			//  finally e depois lança o erro.
			System.out.println("Finally #02...");
			entrada.close();
		}
		
		System.out.println("Fim :)");
		
		
		// CHECADA VS NÃO CHECADA
		
		
		System.out.println();
		
		try {
			geraErro1();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		try {
			geraErro2();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim :)\n");
		
		ExcecaoDefinitivoMain.outroMain(args);
	}	
	
	// CHECADA VS NÃO CHECADA
	
	/*
	 * A raiz de todas as exceções em java é a classe "Exception".
	 * Uma das classes que herdam de Exception é a RuntimeException.
	 * A RuntimeException é uma classe especial em java por que qualquer classe que
	 *  herde dela é uma exceção não checada.
	 *  
	 * Qualquer outra classe que herde de Exception é uma exceção checada.
	 */
	
	// Exceção NÃO checada ou NÃO verificada
	static void geraErro1() /* throws RuntimeException */ {
			// Em uma exceção não checada o compilador te dá a liberdade 
			//  de escolher se você quer ou não tratar o erro.
		
			// No contexto de exceções checadas, nada te impede de colocar na assinatura
			//  desse método que você lança uma RuntimeException.
		 	//   Já que essa exceção não é checada.
		
		throw new RuntimeException("Ocorreu um erro bem legal #01!");
			// Você pode instânciar um erro, uma exceção.
			// Porém, como uma exceção, não basta cria-la, você tem que lança-la.
			// Para lançar um erro utilizasse a palavra "throw"(lançar).
	}
	
	// Exceção checada ou verificada
	static void geraErro2() throws Exception {
			// Em exceções checadas, você é obrigado a colocar na assinatura do método
			//  que você lança esse tipo de exceção.
		
			// Enquanto ela não for tratada, cada método que acessar de alguma forma essa
			//  exceção, será obrigado a realizar a declaração.
		
		throw new Exception("Ocorreu um erro bem legal #02!");
			// Você pode inclusive ter um método que retorna uma exceção.
			// Não tem nenhum problema.
	}
	
	public static void outroMain(String[] args) {
		
		try {
			Aluno aluno = new Aluno("  ", 7);
			ExcecaoDefinitivoAux.aluno(aluno); // Validando aluno.
			
//			ExcecaoDefinitivoAux.aluno(null);
		} catch (ExcecaoDefinitivo | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim :)\n");
		
		
		// Uma exceção pode ser a causa de outra exceção.
		try {
			metodoA(null);
		} catch (IllegalArgumentException e) {
			if(e.getCause() != null) {
				System.out.println(e.getCause().getMessage());
			}
		}
		
		System.out.println("\nMostrando que uma exceção pode causar outra: ");
		metodoA(null);
	}
	
	
	static void metodoA(Aluno aluno) {
		try {
			metodoB(aluno);
		} catch (Exception causa) {
			throw new IllegalArgumentException(causa);
		}
	}
	static void metodoB(Aluno aluno) {
		if(aluno == null) {
			throw new NullPointerException("Aluno esta NULLLOOOO!!!");
		}
		System.out.println(aluno.nome);
	}
	
}
