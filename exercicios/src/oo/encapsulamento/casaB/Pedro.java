package oo.encapsulamento.casaB;

import oo.encapsulamento.casaA.Ana;

public class Pedro extends Ana{

	
	void testeAcessos() {
		
//		Ana mae = new Ana(); Não é necessário já que Pedro herda de Ana.
		
//		System.out.println(segredo);
//		System.out.println(facoDentroDeCasa);
		System.out.println(formaDeFalar);
		System.out.println(todosSabem);
		System.out.println(new Ana().todosSabem);
	}
	
}
