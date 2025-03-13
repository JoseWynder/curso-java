package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {

	public static void main(String[] args) {
		
		List<Produto> produtos = Arrays.asList(
				new Produto("Placa de video", 1415.29, 0.15, 30, false),
				new Produto("Processador", 1198.90, 0.35, 24, true),
				new Produto("SSD NVME", 549.90, 0.09, 14, true),
				new Produto("Gabinete", 309.00, 0.18, 27, true),
				new Produto("Monitor", 2140.29, 0.21, 9, false),
				new Produto("Mouse", 470.08, 0.16, 7, true));
	
		
		Predicate<Produto> desconto = prod -> prod.desconto > 0.15;
		Predicate<Produto> frete = prod -> prod.prazoEntrega < 25;
		Predicate<Produto> garantia  = prod -> prod.boaGarantia;
		Function<Produto, String> produtosEscolhidos = 
				prod -> "Aproveite! " + prod.nome + " esta por R$" + prod.preco + "!";
		
		produtos.stream()
				.filter(desconto)
				.filter(frete)
				.filter(garantia)
				.map(produtosEscolhidos)
				.forEach(System.out::println);

		
		
	}
}
