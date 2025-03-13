package generics.genericsfinal;

public class GenericsDefinitivo<T> {

	
	// RESOLVENDO O TIPO A PARTIR DA INSTÂNCIA.
	
	
	// Exemplo 1
	
//	private Object coisa;
//	
//	public void guardar(Object coisa) {
//		this.coisa = coisa;
//	}
//	
//	public Object abrir() {
//		return coisa;
//	}
	
	// Exemplo 2
	
	private T coisa;
	
	public void guardar(T coisa) {
		this.coisa = coisa;
	}
	
	public T abrir() {
		return coisa;
	}

}
