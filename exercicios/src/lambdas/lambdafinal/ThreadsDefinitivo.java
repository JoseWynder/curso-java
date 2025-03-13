package lambdas.lambdafinal;

public class ThreadsDefinitivo implements Runnable {
	/*
	 * A interface Runnable deve ser implementada por qualquer classe cujas instâncias sejam executadas por um thread.
	 *  A classe deve definir um método sem argumentos chamado run.
	 *  
	 * Esta interface foi projetada para fornecer um protocolo comum para objetos
	 *  que desejam executar código enquanto estão ativos.
	 * 
	 * Por exemplo, Runnable é implementado pela classe Thread.
	 *  Estar ativo significa simplesmente que um thread foi iniciado e ainda não foi interrompido.
	 *  
	 * Uma classe que implementa Runnable pode ser executada sem subclassificar Thread,
	 *  instanciando uma instância de Thread e passando-se como destino.
	 *   
	 * Na maioria dos casos, a interface Runnable deve ser usada se você estiver planejando substituir
	 *  apenas o método run() e nenhum outro método Thread.
	 *  
	 * Isso é importante porque as classes não devem ser subclassificadas,
	 *  a menos que o programador pretenda modificar ou aprimorar o comportamento fundamental da classe. 
	 */

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Tarefa #01");
			try {
				Thread.sleep(100);
				
			} catch (Exception e) {
			}
		}
	}
	
}
