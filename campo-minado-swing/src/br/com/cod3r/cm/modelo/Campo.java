package br.com.cod3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>(); 
	private List<CampoObservador> observadores = new ArrayList<>();
		// Lista para armazenar os observadores.
	
	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public void registrarObservador(CampoObservador observador) {
		observadores.add(observador);
	} // Método para registrar os observadores.
	
	private void notificarObservadores(CampoEvento evento) {
		observadores.stream().forEach(obs -> obs.eventoOcorreu(this, evento));
	} // Resposável por informar que o evento ocorreu.
	
	boolean adicionarVizinho(Campo vizinho) { 

		
		boolean diferencaLinha = Math.abs(linha - vizinho.linha) < 2;
		if (!diferencaLinha)
			return false;
		
		boolean diferencaColuna = Math.abs(coluna - vizinho.coluna) < 2;
		if (!diferencaColuna)
			return false;
		
		if(linha == vizinho.linha && coluna == vizinho.coluna)
			return false;
		
		vizinhos.add(vizinho);
		return true;
	}
	
	public void alternarMarcacao() {
		if(isFechado()) {
			marcado = !marcado;
			
			if(marcado) {
				notificarObservadores(CampoEvento.MARCAR);
			} else {
				notificarObservadores(CampoEvento.DESMARCAR);
			} // Notificar.
		}
	}
	
	public boolean abrir() { 
		if(!aberto && !marcado) {
			if(minado) {
				notificarObservadores(CampoEvento.EXPLODIR);
				return true;
			} // Notificar.
			
			setAberto(true);
			
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean vizinhancaSegura() {
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
		
		if(aberto) {
			notificarObservadores(CampoEvento.ABRIR);
		} // Notificar.
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
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	public int minasNaVizinhanca() {
		return (int) vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
		notificarObservadores(CampoEvento.REINICIAR);
	} // Notificar.
}
