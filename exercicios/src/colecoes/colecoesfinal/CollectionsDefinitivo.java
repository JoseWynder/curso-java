package colecoes.colecoesfinal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet; // SortedSed tambem é um Set(conjunto). 
	// Ele é uma lista de conjuntos que tem algum critério de ordenação(você pode definir).
import java.util.TreeSet;

import colecoes.Usuario;

import java.util.Map.Entry;

public class CollectionsDefinitivo {
	@SuppressWarnings({ "rawtypes", "unchecked"}) // Retira os avisos(warnings) do eclipse.
	public static void main(String[] args) {
		// Tamanho variável
		// Não precisa informar quantos elementos ela vai ter.
		/* Collections podem ter tipos de dados misturados. 
		 * Embora a boa prática diga que você vai ter uma collection de apenas um unico tipo.
		 * Trabalhar com dados homogêneos é muito mais organizado (Preferência).
		 */
		
		// Collections não surportam tipos primitivos. Caso precise, você pode cria um Array ou utilizar um Wrapper.
		
		// Collections (Algumas das estruturas) INTERFACE
		
		
		
		// Set (Conseguimos fazer operações de conjuntos como união e interseção)
		// PODE SER HETEROGÊNEO :(
		// PODE SER HOMOGÊNEO :)
		
		// SET ----------------------------------------- SET ----------------------------------------- SET
		
		
		System.out.printf("\nSET --------------------- SET --------------------- SET\n\n");
		
		
		// SET = Conjunto
		
		/*
		 * NÃO ORDENADO (POR PADRÃO)
		 * NAO INDEXADO
		 * NÃO SUPORTA REPETIÇÃO ( NÃO OCORRE ERRO)
		 */
				
		
		// Vamos trabalhar inicialmente com o HashSet (um dos tipos possíveis)
		
		System.out.printf("Set heterogêneo\n\n");
		
		HashSet conjunto = new HashSet();
		
		conjunto.add("Teste"); // .add() adiciona elementos ao Set
		conjunto.add(true); // boolean - > Boolean (autoboxing)
		conjunto.add(1);
		conjunto.add(2.4);
		
		
		System.out.println("Tamanho é " + conjunto.size()); // .size() tamanho do conjunto	
		
		conjunto.add("Teste"); // Não suporta repetição.
		
		System.out.println("Tamanho é " + conjunto.size());
		
		System.out.println(conjunto.remove("Teste")); // .remove(objeto) remove um elemento (retorna boolean)
		System.out.println(conjunto.remove("Teste")); 
		
		System.out.println("Tamanho é " + conjunto.size());
		
		System.out.println(conjunto.contains('x')); // Verifica se o elemento pertence ao conjunto (retorna boolean)
		System.out.println(conjunto.contains(true));
		
		Set nums = new HashSet();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		System.out.println("nums = " + nums);
		System.out.println("conjunto = " + conjunto);
		
		conjunto.retainAll(nums); // .retainAll() faz a interseção entre os conjuntos.
		
		System.out.println("conjunto interseção = " + conjunto);
		
		conjunto.addAll(nums); // .addAll() faz a união entre os conjuntos.
			// Não mantêm uma ordem dos elementos ao adicionar.
		
		
		System.out.println("conjunto união = " + conjunto);
		System.out.println("nums = " + nums); // .addAll() e .retainAll() não alteram os elementos do conjunto adicionado(nums).
		
		
		
		conjunto.clear(); // .clear() limpa/exclui os elementos do conjunto.
		System.out.println(conjunto);
		
		
		// Set homogêneo
		
		System.out.printf("\nSet homogêneo\n\n");
		
//		Set<String> listaAprovados = new HashSet<>(); // Set<String> == Generic type
													  // HashSet() não respeita ordem de inserção!
		SortedSet<String> listaAprovados = new TreeSet<>(); // TreeSet() Garante ordem de inserção.
		
		listaAprovados.add("Ana");
		listaAprovados.add("Carlos");
		listaAprovados.add("Luca");
		listaAprovados.add("Pedro");
		
//		System.out.println(listaAprovados);
		
		for(String candidato: listaAprovados) {
			System.out.println(candidato);
		}
		
		Set<Integer> numeros = new HashSet<>();
		
		numeros.add(1);
		numeros.add(2);
		numeros.add(120);
		numeros.add(6);
//		
//       // nums.get(1);  Não é possível acessar pelo índice
//	
		for(int n: numeros) {
			System.out.println(n);
		}  
		
		
		
		
		
		// LIST ----------------------------------------- LIST ----------------------------------------- LIST
		
		
		System.out.printf("\nLIST -------------------- LIST -------------------- LIST\n\n");
		
		
		// LIST = Lista
		
		/*
		 * ORDENADA
		 * INDEXADA
		 * ACEITA REPETIÇÃO
		 */			
		
		
		List<Usuario> lista = new ArrayList<>();
		
		Usuario u1 = new Usuario("Ana"); // Criei uma variável
		lista.add(u1); // Adicionei a variável na lista
		
		
		lista.add(new Usuario("Carlos")); // Criei o objeto e coloquei diretamente na lista
		lista.add(new Usuario("Lia"));
		lista.add(new Usuario("Bia"));
		lista.add(new Usuario("Manu"));
		lista.add(new Usuario("Manu")); // Aceita repetição!
		
		System.out.println(lista.get(3).nome); // .get() acessa pelo índice
		
		System.out.println(">>> " + lista.remove(1)); // Removendo pelo índice.
			// .remove(index) retorna o objeto(Usuario) excluído.
		System.out.println(lista.remove(new Usuario("Manu"))); // Removendo a partir de um objeto.
		System.out.println(lista.remove(new Usuario("Manu")));
		System.out.println(lista.remove(new Usuario("Manu")));
		
		System.out.println("Tem? " + lista.contains(new Usuario("Lia"))); 
			// Sem implementar o Equals e HashCode o código não funciona!
				// O mesmo vale para "lista.remove(new Usuario("Manu"))."
		
		System.out.println("Tem? " + lista.contains(u1)); 
			// O único que sem a implementação(Equals e HashCode) temos o resultado esperado!
		
		for(Usuario u: lista) { 
			System.out.println(u); // .toStrig() implícito. Por 'u' ser do tipo Usuario.
		}
	
		
		
		
		
		// QUEUE ----------------------------------------- QUEUE ----------------------------------------- QUEUE
		
		
		System.out.printf("\nQUEUE ------------------- QUEUE ------------------- QUEUE\n\n");
		
		
		// QUEUE = Fila

		/*
		 * IMPLEMENTA FILA
		 * FIRST IN/FIRST OUT (FIFO)
		 */			
		
		
		Queue<String> fila = new LinkedList<>();
		
		// Offer e Add -> adicionam elementos na fila
		// Diferença é o comportamento que ocorre quando a fila está cheia!
		
		fila.add("Ana"); // .add() Lança uma exceção
		fila.offer("Bia"); // .offer() Retorna false
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		// Peek e Element -> obter o próximo elemento da fila (sem remover)
		// Diferença é o comportamento que ocorre quando a fila está vazia!
		
		System.out.println("Peek e Element\n");
		
		System.out.println(fila.peek()); // .peek() retorna null
		System.out.println(fila.peek());
		System.out.println(fila.element()); // .element() Lança uma exceção
		System.out.println(fila.element());
		
		
		// poll e Remove -> obter o próximo elemento da fila e remove.
		// Diferença é o comportamento que ocorre quando a fila está vazia!
		
		System.out.println("\nPoll e Remove\n");
		
		System.out.println(fila.poll()); // .poll() retorna null
		System.out.println(fila.remove()); // .remove() Lança uma exceção
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
//		System.out.println(fila.remove()); // dá erro :(
		
//		fila.size(); // Tamanho da fila
//		fila.clear(); // Limpa a fila
//		fila.isEmpty(); // Verificar se a fila está vazia
//		fila.contains(...) // Verifica se determinado objeto está contido

		
		
		
		
		// STACK ----------------------------------------- STACK ----------------------------------------- STACK
		
		
		System.out.printf("\nSTACK ------------------- STACK ------------------- STACK\n\n");
		
		
		// STACK = Pilha

		/*
		 * IMPLEMENTA PILHA (STACK)
		 * LAST IN/FIRST OUT (LIFO)
		 */			
		
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O Pequeno Príncipe"); // .add() retorna boolean
		livros.push("Don Quixote"); // .push() Lança uma exceção
		livros.push("O Hobbit");
		
		System.out.println("Peek e Element\n");
		
		System.out.println(livros.peek()); // pega "O Hobbit" por ser last in/first out.
		System.out.println(livros.element());
		
		System.out.println("\nForeach\n");
		
		for(String livro: livros) {
			System.out.println(livro);
		}
		
		System.out.println("\nPop, Poll e Remove\n");
		
		System.out.println(livros.pop()); // .pop() remove e Lança uma exceção(caso esteja vazia)
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
//		System.out.println(livros.pop()); // erro
//		System.out.println(livros.remove()); // erro
//		
////		livros.size(); // Tambem estão presentes
////		livros.clear();
////		livros.contains();
////		livros.isEmpty();

		
		
		
		
		// MAP ----------------------------------------- MAP ----------------------------------------- MAP
		
		
		System.out.printf("\nMAP ----------------------- MAP ----------------------- MAP\n\n");
		
		
		// MAP = Mapa

		/*
		 * CHAVE / VALOR
		 * CHAVE NÃO ACEITA REPETIÇÃO
		 * VALOR ACEITA REPETIÇÃO
		 */			
		
		
		Map<Integer, String> usuarios = new HashMap<>(); // 2 valores dentro da anotação do generics
		
		usuarios.put(1, "Roberto"); // .put() adiciona se não existir e substitui caso já exista
		usuarios.put(20, "Ricardo");
		usuarios.put(3, "Rafaela");
		usuarios.put(4, "Rebeca");
		
		System.out.println(usuarios.size());
		System.out.println(usuarios.isEmpty());
		
		System.out.println(usuarios.keySet()); // .keySet() (conjunto de chaves) retorna todas as chaves.
			// Chaves não ordenada
		System.out.println(usuarios.values()); // .values() retorna todos os valores.
		System.out.println(usuarios.entrySet()); // .entrySet() retorna tanto as chaves quanto os valores.
		
		System.out.println(usuarios.containsKey(20)); 
			// .containsKey() Verifica se determinada chave está contida.
		System.out.println(usuarios.containsValue("Rebeca")); 
			// .containsValue() Verifica se determinado valor está contido.
		
		System.out.println(usuarios.get(20)); // .get() retorna o valor da chave informada.
		
		System.out.println();
		
//		System.out.println(usuarios.remove(1)); // .remove(Key) remove e retorna o valor referente aquela chave.
		System.out.println(usuarios.remove(4, "Gui")); // .remove(Key, Value) remove a partir da chave e valor.
		 // (retorna boolean)
		
		System.out.println();

		for(Integer chave: usuarios.keySet()) { // Percorrendo a chave
			System.out.println(chave);
		}
		
		for(String valor: usuarios.values()) { // Percorrendo os valores
			System.out.println(valor);
		}
		
		for(Integer chave: usuarios.keySet()) { // Forma improvisada
				// Percorrendo chave e valor
			System.out.println(chave + " ==> " + usuarios.get(chave));
		}
		
		System.out.println();
		
		for(Entry<Integer, String> registro: usuarios.entrySet()) { // Entry(java.util.Map)
				// Percorrendo chave e valor
			System.out.println(registro.getKey() + " ==> " + registro.getValue());
		}
		
	}
}
