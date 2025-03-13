package lambdas.lambdafinal;

public class ThreadsDefinitivoMain {

	// Essa parte de programação funcional surgiu a partir do java 8.
	// Porem, antes existiam algumas interfaces que tinham um único método.
	// Já era possível utilizar lambdas expression dentro de interfaces que vem do java antes do java 8.
	
	public static void main(String[] args) {
		
		// Thread é um processo que pode ser executado paralelamente. Através do escalonamento.
		Runnable trabalho1 = new ThreadsDefinitivo();
		
		Runnable trabalho2 = new Runnable() {
			// Não faz sentido você implementar uma interface, mas, ao fazer isso você cria uma classe anônima.
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Tarefa #02");
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
					}
				}
			}
		};
		
		Runnable trabalho3 = ThreadsDefinitivoMain::trabalho3;
		
		new Thread(trabalho1).start();
		new Thread(trabalho2).start();
		new Thread(trabalho3).start();
		
//		Thread t1 = new Thread(trabalho1);
//		Thread t2 = new Thread(trabalho2);
//		Thread t3 = new Thread(trabalho3);
		
//		t1.start();
//		t2.start();
//		t3.start();

	}
	
	static void trabalho3() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Tarefa #03");
			try {
				Thread.sleep(100);
				
			} catch (Exception e) {
			}
		}
	};
	
}
