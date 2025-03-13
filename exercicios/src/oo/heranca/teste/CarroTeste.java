package oo.heranca.teste;

import oo.heranca.desafio.Carro;
import oo.heranca.desafio.Civic;
import oo.heranca.desafio.Supra;

public class CarroTeste {

	public static void main(String[] args) {

		Carro carro1 = new Civic();
		Supra carro2 = new Supra();

		System.out.println(carro2.velocidadeDoAr());
		System.out.println("Velocidade Atual (Inicial): " + carro2);
		System.out.println("Velocidade Atual (Frear): " + carro2);

		System.out.println();

//		carro1.velocMaxima = 100;
		
//		carro2.ligarTurbo();
//		carro2.ligarAr();

		for (int i = 0; i < 3; i++) {
			carro1.acelerar();
			carro2.acelerar();
		}
		
//		carro2.desligarTurbo();

		System.out.println("(Acelerar x3): ");
		System.out.println("Civic: " + carro1);
		System.out.println("Supra: " + carro2);

		System.out.println();

		for (int i = 0; i < 100; i++) {
			carro1.acelerar();
			carro2.acelerar();
		}
		System.out.println("(Acelerar x100 Velocidade máxima): ");
		System.out.println("Civic: " + carro1);
		System.out.println("Supra: " + carro2);

		System.out.println();

		for (int i = 0; i < 2; i++) {
			carro1.frear();
			carro2.frear();
		}

		System.out.println("(Frear x2): ");
		System.out.println("Civic: " + carro1);
		System.out.println("Supra: " + carro2);

		System.out.println();

		for (int i = 0; i < 20; i++) {
			carro1.frear();
			carro2.frear();
		}
		System.out.println("(Frear x20): ");
		System.out.println("Civic: " + carro1);
		System.out.println("Supra: " + carro2);

		
	}
}
