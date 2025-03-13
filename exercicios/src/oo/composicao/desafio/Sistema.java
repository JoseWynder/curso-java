package oo.composicao.desafio;

public class Sistema {
	public static void main(String[] args) {
		
		Cliente Cliente1 = new Cliente("José");
		
		Compra compra1 = new Compra();
		compra1.adicionarItem("Caneca", 25, 2);
		compra1.adicionarItem(new Produto("Café", 18.9), 5);
		
		Compra compra2 = new Compra();
		compra2.adicionarItem("Mouse", 89.9, 1);
		compra2.adicionarItem(new Produto("toalha", 30), 3);
		
		Cliente1.compras.add(compra1);
		Cliente1.adicionarCompra(compra2);
		
		
		System.out.println(Cliente1.obterValorTotal());
	}
}
