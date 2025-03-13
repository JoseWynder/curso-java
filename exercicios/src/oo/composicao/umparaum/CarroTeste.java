package oo.composicao.umparaum;

public class CarroTeste {
	public static void main(String[] args) {
		
		Carro c1 = new Carro(); // Instânciei um objeto do tipo "Carro"
		System.out.println(c1.estaLigado());
		
		c1.ligar();
		
		System.out.println(c1.estaLigado());
		
		System.out.println(c1.motor.giros()); /* Não é possível acessar o método "giros" diretamente
		 	*  (Já que "giros" é um método existente apenas dentro de "Motor", e c1 é do tipo "Carro").
		 	* Como solução, posso usar a instância "c1" para acessar o atributo "motor" existente em "Carro"
		 	*  e apartir daí acessar giros().
		 	*/ 
		
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		
		System.out.println(c1.motor.giros());
		
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		
		System.out.println(c1.motor.giros());
		
		// Relação bidirecional!
		System.out.println(c1.motor.carro.motor.carro.motor.giros()); // isso é possível com uma relação bidirecional.
		// Via de regra uma relação bidirecional só é usada quando realmente são nescessárias.
	}
}
