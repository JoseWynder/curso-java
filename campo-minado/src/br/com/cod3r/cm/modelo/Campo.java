package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.cod3r.cm.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>(); 
		// Relacionamento 1 para n com a própria classe.
	
	Campo(int linha, int coluna) { // Para gerar um quadrado.
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) { 
			// Lógica para dizer quais campos estão no envolto de um campo.
			// Para realizar o processo de expansão do tabuleiro.
		
		boolean diferencaLinha = Math.abs(linha - vizinho.linha) < 2;
		if (!diferencaLinha)
			return false;
		
		boolean diferencaColuna = Math.abs(coluna - vizinho.coluna) < 2;
		if (!diferencaColuna)
			return false;
		
		if(linha == vizinho.linha && coluna == vizinho.coluna)
			return false;
		
		vizinhos.add(vizinho); // Adicionando vizinho.
		return true;
	}
	
	void alternarMarcado() { // Para marcar e desmarcar o campo.
		if(isFechado()) {
			marcado = !marcado;
		}
	}
	
	boolean abrir() { 
		// Para abrir um campo e caso tenha uma mina, lançar uma ExplosaoException.
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new ExplosaoException();
			}
			
			if(vizinhancaSegura()) { // Recursividade. Um método chamando a si mesmo.
				vizinhos.forEach(v -> v.abrir());
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	boolean vizinhancaSegura() { // Verificar se tem alguma mina envolta do campo.
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	void minar() {
		minado = true;
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isFechado() {
		return !aberto;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	boolean objetivoAlcancado() { 
			// Verificando se o Objetivo de um campo foi alcançado.
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	long minasNaVizinhanca() { // A quantidade de minas envolta.
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	@Override
	public String toString() { // Mostrar o campo no terminal.
		if(marcado) {
			return "x";
		} else if(aberto && minado) {
			return "*";
		} else if(aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		} else if(aberto) {
			return " ";
		} else {
			return "?";
		}
	}
	
}
