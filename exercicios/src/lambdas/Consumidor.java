package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {

	public static void main(String[] args) {
		
		Consumer<Produto> imprimirNome = prod -> System.out.println(prod.nome);
		
		Produto p1 = new Produto("Caneta", 12.34, 0.09);
//		imprimirNome.accept(p1);
		Produto p2 = new Produto("Notebook", 2987.99, 0.25);
		Produto p3 = new Produto("Caderno", 19.90, 0.03);
		Produto p4 = new Produto("Borracha", 7.80, 0.18);
		Produto p5 = new Produto("Lapís", 4.39, 0.19);
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);
		
		System.out.println();
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println(produtos.get(i).nome);
		}
		
		System.out.println();
		for (Produto prod : produtos) {
			System.out.println(prod.nome);
		}
		
		System.out.println();
		produtos.forEach(prod -> System.out.println(prod.nome));
		
		System.out.println();
		produtos.forEach(System.out::println);
		
		System.out.println();
		produtos.forEach(imprimirNome);
		
	}
}
