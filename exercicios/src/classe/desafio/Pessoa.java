package classe.desafio;

public class Pessoa {
	
	String nome;
	float peso;
	
	Pessoa(String nome, float peso){
		this.nome = nome;
		this.peso = peso;
	}
	
	void Comer(Comida comida) {
		if(comida != null) {
			this.peso += comida.peso;
		}
	}
	
	String apresentar() {
		return "Olá eu sou o " + nome + " e tenho " + peso + "Kg";
	}
}
