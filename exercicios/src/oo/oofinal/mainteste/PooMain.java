package oo.oofinal.mainteste;

import oo.oofinal.PooSub;

public class PooMain {

	public static void main(String[] args) {

//		PooSuper carro1 = new PooSuper(); 
			//Criar uma variável(PooSuper carro1 = ) do tipo PooSuper não é possível caso a classe "PooSuper" seja package!
			//Criar um objeto(new PooSuper() ) do tipo PooSuper não é possível caso o construtor de PooSuper seja protected
			// ou a classe PooSuper seja abstract!
		PooSub carro1 = new PooSub(); 
			// O Java pega o método acelerar de PooSub mesmo sendo uma variável PooSuper.
		

		
		System.out.println("Velocidade Atual (Inicial): " + carro1);
		System.out.println("Velocidade Atual (Frear): " + carro1);
		
		System.out.println(carro1.velocidadeDoAr());

		System.out.println();
		
//		System.out.println(carro1.velocMaxima); // Graças ao dado ser público.
		
		carro1.ligarAr();
		carro1.ligarTurbo(); 
				// Não seria possível acessar esses métodos caso a instância fosse uma variável de PooSuper.
				// Já que esses métodos só existe em PooSub.
		
		
		for (int i = 0; i < 3; i++) {
			carro1.acelerar();
		}
		
		carro1.desligarTurbo();

		System.out.println("(Acelerar x3): ");
		System.out.println("Supra: " + carro1);

		System.out.println();

		for (int i = 0; i < 100; i++) {
			carro1.acelerar();
		}
		System.out.println("(Acelerar x100 Velocidade máxima): ");
		System.out.println("Supra: " + carro1);

		System.out.println();

		for (int i = 0; i < 2; i++) {
			carro1.frear();
		}

		System.out.println("(Frear x2): ");
		System.out.println("Supra: " + carro1);

		System.out.println();

		for (int i = 0; i < 20; i++) {
			carro1.frear();
		}
		System.out.println("(Frear x20): ");
		System.out.println("Supra: " + carro1);

		
		carro1.getInfo();
	}
	
}
