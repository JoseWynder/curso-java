package lambdas.lambdafinal;

public class LambdaDefinitivo /* extends Object */ {
	
	final String nome;
	final double preco;
	final double desconto;
	
	public LambdaDefinitivo(String nome, double preco, double desconto) {
		/* super(); */
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}
	@Override
	public String toString() {
		return nome;
	}
}
