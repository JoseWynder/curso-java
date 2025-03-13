package oo.oofinal;

public interface PooInterface1 {

	
	/* Uma interface tem métodos que não podem ter corpo.
	 * interface também defini um tipo, uma estrutura de dados.
	 * A interface define apenas a necessidade de implementar algo
	 *  quando uma classe herda de uma interface.
	 *  
	 * Uma classe pode herdar de multiplas interfaces.
	 * 
	 * Em algum momento eu quero determinar que uma classe vai ter um comportamento,
	 *  mas, não sei como implementá-lo.
	 * Nesse cenário você pode usar a interface.
	 * Estabelecer que uma classe tem um certo método porque é algo que você vai implementar
	 *  especificamente em cada uma das classes. Seria um motivo.
	*/ 
	
	public abstract void ligarTurbo();
		// Por padrão:
		// Todo método dentro de uma interface é "public".
		// Todo método dentro de uma interface é "abstract".
	
	void desligarTurbo();
}
