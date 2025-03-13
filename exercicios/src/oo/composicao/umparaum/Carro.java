package oo.composicao.umparaum;

public class Carro {

	final Motor motor;// Posso deixar nulo ( ooMotor motor; ) OU
	/* para ter um valor padrão, eu já poderia inicializar o motor diretamente na hora
	 *  da declaração( ooMotor motor = new ooMotor(); ) OU 
	 * posso inicializa-lo no construtor OU 
	 * receber como parâmetro para o construtor um motor.
	 */

	Carro() { // Para gerar uma relação bidirecional
		this.motor = new Motor(this);
	}

	void acelerar() {
		if (motor.fatorInjecao < 2.6) {
			motor.fatorInjecao += 0.4;
		}
	}

	void frear() {
		if (motor.fatorInjecao > 0.5) {
			motor.fatorInjecao -= 0.4;
		}
	}

	void ligar() {
		motor.ligado = true;
	}

	void desligar() {
		motor.ligado = false;
	}

	boolean estaLigado() {
		return motor.ligado;
	}
}
