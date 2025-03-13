package streams.streamsfinal;

public class streamMedia {

	private double total;
	private int quantidade;
	
	public streamMedia adicionarNota(double valor) {
		total += valor;
		quantidade++;
		return this;
	}
	
	public double getMedia() {
		return total / quantidade;
	}
	
	public static streamMedia combinar(streamMedia m1, streamMedia m2) {
		streamMedia resultante = new streamMedia();
		resultante.total = m1.total + m2.total;
		resultante.quantidade = m1.quantidade + m2.quantidade;
		return resultante;
	}
}
