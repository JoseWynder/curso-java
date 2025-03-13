package oo.composicao.umparaum;

public class Motor {

	final Carro carro; // Para gerar uma relação bidirecional
	boolean ligado = false;
	double fatorInjecao = 1;

	Motor(Carro carro) { // Para gerar uma relação bidirecional
		this.carro = carro;
	}

	int giros() {
		if (!ligado) {
			return 0;
		} else {
			return (int) Math.round(fatorInjecao * 3000); // Math.round() arredonda
		}
	}

}
