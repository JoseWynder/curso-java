package oo.oofinal;

public class PooSub extends PooSuper implements PooInterface1, PooInterface2 { 
	// extends define herança.
	// implements define interface.


	boolean ligarTurbo;
	boolean ligarAr;

	
	public PooSub() { 
		// O construtor padrão de uma sub classe chama(por padrão) o construtor padrão da super classe.
		super(280); 
       // Utilizando "super()" e "super." eu acesso o construtor e os comportamentos da super classe.
		setAceleracao(15);
	}

//	{ aceleracao = 5; } // O privated invalida.
	
//	@Override //(annotation) sobrescrevendo o método da super classe
//	public final void acelerar() { // Ao sobrescrever um método, não é possível diminuir sua visibilidade!
//		// O final não permite a mudança
//		velocAtual += 15; 
//		// atributo private
//	}
	
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
			return super.getAceleracao(); // Aceleração padrão!
		return 10;
	}
	
	
}
