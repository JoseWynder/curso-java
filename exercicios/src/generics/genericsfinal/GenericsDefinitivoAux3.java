package generics.genericsfinal;

import java.util.List;

public class GenericsDefinitivoAux3 {
	
	
	// GENERICS EM MÉTODOS
	
	/*
	 * Imaginando um cenário em que você vai criar um método porque precisa realizar
	 *  frequentemente a captura de elementos de uma lista. Como você trabalha com
	 *   listas que tem tipos genéricos, o interessante é que se você quer pegar um
	 *    elemento específico da lista, como por exemplo, o penultimo elemento, você
	 *     pegue do tipo que já faz parte da lista. Se é uma lista de String, que
	 *      esse método retorne uma String. Se é uma lista de Clientes, que esse
	 *       método retorne um Cliente. Nessa situação é interessante utilizar
	 *        generics, não em um contexto de classe, mas sim de métodos.
	 */
	
	
	public static Object getUltimo1(List<?> lista) {
		// List e List<?> são == a List<? extends Object> e diferentes de List<Object>.
		// List<Object> diz que você quer uma lista especificamente do tipo Object.
		// List<? super Integer> se refere a T ou um super de T, nesse caso "Integer".
		return lista.get(lista.size() - 1);
	}
	
	public static <T> T getUltimo2(List<T> lista) {
		// Esse generics no método diz que ele retorna o mesmo parâmetro que recebe;
		// É possível: "public static <T> Object getUltimo2(List<T> lista)".
		return lista.get(lista.size() - 1);
	}
	
	public static <A, B, C> C teste(A paramA, B paramB) {
			// Sem problemas.
		C teste = null;
		return teste;
	}
}
