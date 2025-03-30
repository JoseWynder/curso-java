package classe.classefinal;

import java.util.HashSet;

import colecoes.Usuario;

public class EqualsHashCodeMain {
	
	public static void main(String[] args) {
		
		var u1 = new EqualsHashCode(); 
			// Na memória do computador eu tenho uma variável u1 associada a um endereço na memória.
		u1.nome = "Caneta";
//		u1.email = "1234";
		
		var u2 = new EqualsHashCode(); 
		// Na memória do computador eu tenho uma variável u2 associada a outro endereço na memória.
		u2.nome = "Caneta";
//		u2.email = "1234";
		
		System.out.println(u1==u2); // False
			// Comparação "==" verifica endereço de memória e não o conteúdo da variável!
		
		float a = 3.2F;
		float b = 3.2F;
		
		System.out.println(a==b); // True
			// Como em tipos primitivos há atribuição por valor, não ocorre essa distinção entre endereços de memórias diferentes.
		
		// Para isso surge o método Equals. Fazer uma comparação entre objetos utilizando qualquer critério que você passar.
		// Ele é um método que está disponível em todos os objetos em Java.
		
		System.out.println(u1.equals(u2)); // False
			// O resultado continua dando false porque por padrão o equals compara da mesma forma que o "==".
			// (caso ele já não tenha sido implementado na classe 'EqualsHashCode').
		
		
		// HashCode retorna int
		// Equals retorna boolean
		
		
		/* O equals é um método mais lento do que o HashCode por utilizar critérios de comparação mais completos.
		 * Usando 1, 2, as vezes 10 atributos dependendo de quão complexos é a lógica para definir a igualdade.
		 * O HashCode faz uma varredura rápida deixando quem realmente tem possibilidade de ser igual.
		 * Criando assim, um subconjunto para facilitar a utilização do equals.
		 * Equals e HashCode andam juntos! Ambos têm de ser implementados para ter o comportamento esperado.
		 */
		
		
		
		HashSet<Usuario> usuarios = new HashSet<>(); // Usuario de colecoes.
		
		usuarios.add(new Usuario("Pedro"));
		usuarios.add(new Usuario("Ana"));
		usuarios.add(new Usuario("Guilherme"));
		
		boolean resultado = usuarios.contains(new Usuario("Guilherme"));
			// O Equals e o HashCode são utilizando em todos os métodos que utilizam alguma forma de comparação.
		
		System.out.println("resultado = " + resultado);	
		
		
	}
	
}
