package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.cod3r.cm.excecao.ExplosaoException;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
			// Gerar o tamanho do tabuleiro e a quantidade das minas.
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		// Inicializando o tabuleiro.
		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}
	
	public void abrir(int linha, int coluna) {
		try {
			campos.parallelStream()
			  .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			  .findFirst() // Pegar o primeiro elemento(Optional de Campo).
			  .ifPresent(c -> c.abrir());
		} catch (ExplosaoException e) {
			campos.forEach(c -> c.setAberto(true));
			throw e; // Propagando a excesão para outra classe.
		}
	}
	
	public void alternarMarcacao(int linha, int coluna) {
		campos.parallelStream()
			  .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			  .findFirst()
			  .ifPresent(c -> c.alternarMarcado());
	}
	
	
	private void gerarCampos() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				campos.add(new Campo(linha, coluna));
			}
		}
	}
	
	private void associarVizinhos() {
		for(Campo c1: campos) {
			for(Campo c2: campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}
	
	private void sortearMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		
		do {
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();
		} while(minasArmadas < minas);
	}
	
	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}
	
	@Override
	public String toString() { // Cria a UI.
		StringBuilder sb = new StringBuilder(); 
		// Melhor no ponto de vista de memória quando tem uma grande
		//  quantidade de concatenações e modificações de String.
		// Além de dar acesso a alguns métodos de manipulação.
		sb.append("\n  y");
		for (int coluna = 0; coluna < colunas; coluna++) {
			sb.append(" ");
			sb.append(coluna);
			sb.append(" ");

		}
		sb.append("\n");
		sb.append("x");
		sb.append(" +");
		
		for (int coluna = 0; coluna < colunas; coluna++) {
			sb.append(" ");
			sb.append("–");
			sb.append(" ");
		}
		sb.append("+");
		sb.append("\n");
		
		int i = 0;
		for (int linha = 0; linha < linhas; linha++) {
			sb.append(linha);
			sb.append(" |");
			for (int coluna = 0; coluna < colunas; coluna++) {
				sb.append(" ");
				sb.append(campos.get(i));
				sb.append(" ");
				i++;
			}
			sb.append("|");
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
