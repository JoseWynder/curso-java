package classe.desafio;

public class Jantar {
	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa("José", 75);
		
		Comida c1 = new Comida("Marmita", 1);
		
		Comida c2 = new Comida("Hamburguer", 0.5f);
		
		System.out.println(pessoa.apresentar());
		
		pessoa.Comer(c1);
		pessoa.Comer(c2);
		
		System.out.println("O meu peso depois de comer é " + pessoa.peso + "Kg");
	}
}
