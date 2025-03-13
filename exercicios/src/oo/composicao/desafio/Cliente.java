package oo.composicao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	final String nome;
	final List<Compra> compras = new ArrayList<>();
	
	Cliente(String nome){
		this.nome = nome;
	}
	
	void adicionarCompra(Compra compra) {
		this.compras.add(compra);
	}
	
	
	double obterValorTotal(){
		double total = 0;
		for (Compra compra : compras) {
			total += compra.obterValorTotal();
		}
		return total;
	}
	
	/*
	 * 1 Cliente | done
	 * 2 Compras | done
	 * Cada compra com 2 itens | done
	 * Cada Item associado a produtos diferentes | done
	 */
}
