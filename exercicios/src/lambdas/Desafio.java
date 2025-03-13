package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {

	public static void main(String[] args) {
		

        Function<Produto, Double> precoComDesconto = 
                prod -> prod.preco * (1 - prod.desconto);

        UnaryOperator<Double> precoComImpostoMunicipal =
                preco -> preco >= 2500 ? (preco * 1.085) : preco;

        UnaryOperator<Double> precoComFrete =
                preco -> preco >= 3000 ? preco + 100 : preco + 50;

        UnaryOperator<Double> precoArredondado = 
                preco -> Double.parseDouble(String.format("%.2f", preco));
		
        Function<Double, String> precoFormatado = preco -> ("R$" + preco).replace(".", ",");
				
        
        Produto produto = new Produto("iPad", 3235.89, 0.13);
	
		String precoFinal = precoComDesconto
				.andThen(precoComImpostoMunicipal)
				.andThen(precoComFrete)
				.andThen(precoArredondado)
				.andThen(precoFormatado)
				.apply(produto);
		
		System.out.println("O preco final ficou " + precoFinal);
		
		
	}
}
