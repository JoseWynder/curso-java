package padroes.observer.observerfinal;

public class Observer implements InterfaceEvento {
	
	@Override
	public void ocorreu(Evento evento) {
		System.out.println("Observer notificado!!!");
	}
}
