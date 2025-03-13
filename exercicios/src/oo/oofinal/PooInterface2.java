package oo.oofinal;

public interface PooInterface2 {

	void ligarAr();
	
	void desligarAr();
	
	default int velocidadeDoAr() {// Definição padrão
		return 1;
	}
}
