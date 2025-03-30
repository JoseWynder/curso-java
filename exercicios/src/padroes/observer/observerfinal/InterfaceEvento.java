package padroes.observer.observerfinal;

@FunctionalInterface
public interface InterfaceEvento {

	public abstract void ocorreu(Evento evento);
}
