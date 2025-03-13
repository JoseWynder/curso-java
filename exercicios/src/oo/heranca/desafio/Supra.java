package oo.heranca.desafio;

public class Supra extends Carro implements Esportivo, Luxo {
	

//	{ aceleracao = 5; } // O privated invalida.

	boolean ligarTurbo;
	boolean ligarAr;

	public Supra() {
		super(280);
		setAceleracao(15);
	}

	@Override
	public void ligarTurbo() {
		ligarTurbo = true;
	}

	@Override
	public void desligarTurbo() {
		ligarTurbo = false;
	}

	@Override
	public void ligarAr() {
		ligarAr = true;
	}

	@Override
	public void desligarAr() {
		ligarAr = false;
	}

	@Override
	public double getAceleracao() {
		if (ligarTurbo) {
			if (!ligarAr)
				return 35;
			return 30;
		} else if (!ligarAr)
			return 15; // Aceleração padrão!
		return 10;
	}

}
