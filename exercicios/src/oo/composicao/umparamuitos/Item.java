package oo.composicao.umparamuitos;

public class Item {
	
	String nome;
	int quantidade;
	double preco;
	Compra compra; // Para gerar uma relação bidirecional
	
	Item(String nome, int quantidade, double preco){
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

}
