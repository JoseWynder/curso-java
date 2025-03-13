package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tabuleiro implements CampoObservador {

	private final int linhas;
	private final int colunas;
	private final int minas;
	
	private final List<Campo> campos = new ArrayList<>();
	private final List<Consumer<ResultadoEvento>> observadores = new ArrayList<>();
		// Lista para notificar quando ocorrer uma vitoria ou derrota.
		

	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}
	
	public void paraCadaCampo(Consumer<Campo> funcao) {
		campos.forEach(funcao);
	}
	
	public void registrarObservador(Consumer<ResultadoEvento> observador) {
		observadores.add(observador);
	} // Registrar os observadores.
	
	private void notificarObservadores(Boolean resultado) {
		observadores.stream().forEach(result -> result.accept(new ResultadoEvento(resultado)));
	} // Notificar os observadores.
	
	public void abrir(int linha, int coluna) {
			campos.parallelStream()
			  .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			  .findFirst()
			  .ifPresent(c -> c.abrir());
	}
	
	public void alternarMarcacao(int linha, int coluna) {
		campos.parallelStream()
			  .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			  .findFirst()
			  .ifPresent(c -> c.alternarMarcacao());
	}
	
	
	private void gerarCampos() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				Campo campo = new Campo(linha, coluna);
				campo.registrarObservador(this);
				campos.add(campo);
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
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		if(evento == CampoEvento.EXPLODIR) {
			mostrarMinas();
			notificarObservadores(false);
		} else if(objetivoAlcancado()) {
			notificarObservadores(true);
		} // Notificar.
	}
	
	private void mostrarMinas() {
		campos.stream()
		.filter(c -> c.isMinado())
		.forEach(c -> c.setAberto(true));
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	
}
