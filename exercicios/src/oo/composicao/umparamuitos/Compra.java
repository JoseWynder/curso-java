package oo.composicao.umparamuitos;

import java.util.ArrayList;

public class Compra {

	
	String Cliente;
	ArrayList<Item> itens = new ArrayList<>(); // Uma compra tem uma lista de itens
	
	
	void adicionarItem(String nome, int quantidade, double preco) {
		this.adicionarItem(new Item(nome, quantidade, preco));
	}
	
	void adicionarItem(Item item) { 
		this.itens.add(item);
		item.compra = this; // Para gerar uma relação bidirecional
			// A compra associada ao item é a classe atual
	}
	
	
	double obterValorTotal() {
		double total = 0;
		
		for(Item item: itens){
			total += item.quantidade * item.preco;
		}
		
		return total;
	}
	
}
