package lambdas.lambdafinal;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaDefinitivoMain {

	public static void main(String[] args) {
		
		// Lambda é um elemento da programação funcional.
		
		/* Funções Lambdas são funções anônimas(sem nome).
		 * O resultado dessas funções você associa a uma variável.
		 * Em várias linguagens de programação isso é extremamente natural. Como por exemplo: JavaScript.
		 * As funções lambdas tiram a necessidade de criar uma classe que implementa uma interface, ...
		 * Com apenas uma única linha você já consegue ter essa implementação.
		 */ 
		
		LambdaInterface calculo = (x, y) -> { return x + y; };
		System.out.println(calculo.executar(2, 3));
		// A variável "calculo" é do tipo "LambdaInterface" que é uma interface.
		// E essa interface tem apenas um único método abstract. Por isso,
		//  o java sabe que essa lambda segue os padrões desse método definido em "LambdaInterface".
		
		calculo = (x, y) -> x * y; // Implicitamente existe um return associado a essa expressão.
		System.out.println(calculo.executar(2, 3));
		
		System.out.println(calculo.executor(2, 3));
		System.out.println(LambdaInterface.muitoLegal());
		
		
		
		// O java não permite:
		// primitivo -> classe
		// Apenas se forem correspondentes. Ex: double -> Double (autoboxing e unboxing)
		
//		Integer integer = 9; // autoboxing
//		int in = 0; in = new Integer(9); // unboxing
			// The constructor Integer(int) has been deprecated since version 9 and marked for removal.
		
//		double a = 1; // SIM
//		Double b = 1; // NÃO
//		Double c = 1.0; // -> Certo
		
		// Generics só permite classes.
		BinaryOperator<Double> calc = (x, y) -> { return x + y; };
		System.out.println(calc.apply(2.0, 3.0));
		
		calc = (x, y) -> x * y;
		System.out.println(calc.apply(2.0, 3.0));
		
		
		// Interfaces Funcionais
		
		/*|-----------------|-----------------|
		 *|   ASSINATURA    |       NOME      |
		 *|-----------------|-----------------|
		 *| nada -> T       |  Supplier       |
		 *| T    -> nada    |  Consumer       |
		 *| T    -> T       |  UnaryOperator  |
		 *| T,T  -> T       |  BinaryOperator |
		 *| S    -> T       |  Function       |
		 *| T    -> boolean |  Predicate      |
		 *|-----------------|-----------------|*/
		
		// interfaces focadas em tipos primitivos
		
		/*
		 * IntBinaryOperator
		 * LongBinaryOperator
		 * ...
		 */
		
		Consumer<LambdaDefinitivo> imprimirNome = prod -> System.out.println(prod.nome);
		
		var p1 = new LambdaDefinitivo("Caneta", 12.34, 0.09);
//		imprimirNome.accept(p1);
		var p2 = new LambdaDefinitivo("Notebook", 2987.99, 0.25);
		var p3 = new LambdaDefinitivo("Caderno", 19.90, 0.03);
		var p4 = new LambdaDefinitivo("Borracha", 7.80, 0.18);
		var p5 = new LambdaDefinitivo("Lapís", 4.39, 0.19);
		
		List<LambdaDefinitivo> produtos = Arrays.asList(p1, p2, p3, p4, p5);
		// . asList() Adiciona elementos e torna a lista fixa.
				//  Gerando erro ao adicionar ou retirar elementos.
				// Permite modificação dos elementos presentes.
//		produtos.set(4, new LambdaDefinitivo("Tesoura", 14.29, 0.15)); // .set(,) altera um elemento pelo index.
		
		
        // Em ordem de flexibilidade //
		
		System.out.println("\n\nFor\n");
		for (int i = 0; i < produtos.size(); i++) { // Pode escolher como percorrer, o que fazer e como fazer.
			System.out.println(produtos.get(i).nome);
		}
		
		System.out.println("\nForeach\n");
		for (LambdaDefinitivo prod : produtos) { // Pode escolher o que fazer e como fazer.
			System.out.println(prod.nome);
		}
		
		System.out.println("\nMétodo forEach + Lambda\n");
		produtos.forEach(prod -> System.out.println(prod.nome)); // Pode escolher como fazer.
		
		System.out.println("\nMétodo forEach + Consumer\n");
		produtos.forEach(imprimirNome); // Pode fazer ou mudar o que fazer no "imprimirNome".
		
		System.out.println("\nMétodo forEach + referência para método\n");
		produtos.forEach(LambdaDefinitivoMain::meuImprimir); // Pode fazer ou mudar o que fazer no "meuImprimir".
		// Referência de um método.
		
		System.out.println("\nMétodo forEach + referência para syso\n");
		produtos.forEach(System.out::println); // Pode fazer ou mudar o que fazer no "toString()".
			// .toString() implícito definido em LambdaDefinitivo.
		
		
		Supplier<List<String>> umaLista = // Generics do Supplier sendo um List de String.
				() -> Arrays.asList("Ana", "Bia", "Lia", "Gui"); // Obrigatório "()" quando o parâmetro é void.
				
		System.out.println("\n" + umaLista.get());
		
	}
	
		static void meuImprimir(LambdaDefinitivo produto) {
			System.out.println(produto.nome);
		}
}
