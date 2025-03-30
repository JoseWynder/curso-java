package oo.oofinal;


abstract class PooSuper extends Object { // Uma classe também pode ser package.
		// Toda classe extends de Object.

	public final int VELOCMAXIMA;// Não há problema em definir "public" um dado "final"(só é possível ler).
		// A preferência seria deixa-lo "private", tirar o "final" e criar um set.
	    //  Mas, como não vou precisar definir uma velocidade máxima, posso deixar assim.
	private double aceleracao; // Tem seu get e set.
	private double velocAtual; // Tem seu get e não é para ter o set.
	
	
	protected PooSuper() {
		this(210);
	}

	protected PooSuper(final int VELOCMAXIMA) { 
		this.VELOCMAXIMA = validarVelocMaxima(VELOCMAXIMA);
			// Pelo atributo "velocMaxima" ser "final" não é possível usar um "set" e inicializa-lo fora do construtor.
			// Mas dá para criar um método "private" para fazer a validação.
		this.aceleracao = 5;
		this.velocAtual = 0;
	}

	private int validarVelocMaxima(final int VELOCMAXIMA) { // Validar a velocidade máxima.
		if(VELOCMAXIMA > 0)
			return VELOCMAXIMA;
		return 40;
	}
	
	public final void acelerar() { // Método final não permite sobrescrita(@Override).
		if (velocAtual <= VELOCMAXIMA - getAceleracao()) {
			velocAtual += getAceleracao();
		} else if (velocAtual < VELOCMAXIMA) {
			velocAtual = VELOCMAXIMA;
		}
	}

	public final void frear() {
		velocAtual = velocAtual >= 10 ? velocAtual - 10 : 0;
	}

	public String toString() {
		return "Velocidade atual é " + velocAtual + "Km/h.";
	}

	
	// Getters/Setters
		// Quando se cria atributos variáveis em uma classe, via de regra,
	    //  você define esses atributos como "private" e cria métodos getters e setters.
	
	protected final void setAceleracao(final double aceleracao) {
			// set para evitar alterações indesejadas sem nenhum tipo de filtro.
		if(aceleracao > this.aceleracao)
		this.aceleracao = aceleracao;
	}

	public double getAceleracao() {
		return aceleracao;
	}
	
	public void getInfo() {
		System.out.println();
		System.out.println("Velocidade máxima: " + VELOCMAXIMA + "km/h");
		System.out.println("Aceleração: " + getAceleracao() + "km");
		System.out.println("Velocidade atual: " + velocAtual + "km/h");
		System.out.println();
	}
	
//	public double getVelocAtual() {
//		return velocAtual;
//	}
	

}
