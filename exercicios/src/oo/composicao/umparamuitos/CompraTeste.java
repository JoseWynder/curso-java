package oo.composicao.umparamuitos;

public class CompraTeste {
	public static void main(String[] args) {
		
		Compra compra1 = new Compra();
		compra1.Cliente = "João Pedro"; //             |       
		// Diferentes maneiras de adicionar um item    v
		compra1.adicionarItem("Caneta", 20, 7.45); // Adiciona o Item na lista e adiciona a compra ao Item (bidirecional)
		compra1.adicionarItem(new Item("Caneta", 12, 3.89)); // Faz o mesmo que o acima.
		compra1.itens.add(new Item("Caderno", 3, 18.79)); // Só adicionando à lista "itens"
		
		System.out.println(compra1.itens.size());
		System.out.println(compra1.obterValorTotal());
		
		// Só para mostrar a relação bidirecional!!!
		double total = compra1.itens.get(0).compra.itens.get(1).compra.obterValorTotal();
		System.out.println("O total é " + total);
	}
}
