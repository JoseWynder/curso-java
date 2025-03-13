package generics.genericsfinal;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import generics.Par;

public class GenericsDefinitivoAux4<C extends Number, V> {
	
	// Algumas coisas interessantes no código.
	

	private final Set<Par<C, V>> itens = new LinkedHashSet<>();
		// Usando o generics da classe como generics do Set.
	
	public void adicionar(C chave, V valor) {
		if(chave == null) return;
			// Return em método void.
		
		Par<C, V> novoPar = new Par<C, V>(chave, valor);
		
		if(itens.contains(novoPar)) {
			itens.remove(novoPar);
		}
		
		itens.add(novoPar);
	}
	
	public V getValor(C chave) {
		if(chave == null) return null;
		
		Optional<Par<C, V>> parOptional = itens.stream()
				    .filter(par -> chave.equals(par.getChave()))
				    .findFirst();
			// Criando um Optional de "Par<C, V>".
			// Optional é uma classe que pode ou não conter o valor "null".
		
		return parOptional.isPresent() ? parOptional.get().getValor() : null;
	}
}
