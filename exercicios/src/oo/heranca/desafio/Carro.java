package oo.heranca.desafio;

public abstract class Carro {

	private final int velocMaxima;
	private double aceleracao;
	private double velocAtual;

	Carro() { // Civic e Supra estão recebendo esse construtor por padrão!
		this(210);
	}

	Carro(int velocMaxima) { // Mas não recebem outros além do padrão!
		this.velocMaxima = velocMaxima;
		aceleracao = 5;
		velocAtual = 0;
	}

	public final void acelerar() {
		if (velocAtual <= velocMaxima - getAceleracao()) {
			velocAtual += getAceleracao();
		} else if (velocAtual < velocMaxima) {
			velocAtual = velocMaxima;
		}
	}

	public void frear() {
		velocAtual = velocAtual >= 10 ? velocAtual - 10 : 0;
	}

	public String toString() {
		return "Velocidade atual é " + velocAtual + "Km/h.";
	}

	final void setAceleracao(double aceleracao) {
		this.aceleracao = aceleracao;
	}

	public double getAceleracao() {
		return aceleracao;
	}

}
