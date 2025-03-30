package padroes.observer.observerfinal;

public class Main {
	public static void main(String[] args) {
		Subject sub = new Subject();
		Observer obs = new Observer();
		
		sub.adicionarObserver(obs);
		
		sub.adicionarObserver(e -> {
			System.out.println("Surpresa via lambda!");
			System.out.println("Ocorreu em: " + e.getData());
		});
		
		sub.monitorar();
	}
}
