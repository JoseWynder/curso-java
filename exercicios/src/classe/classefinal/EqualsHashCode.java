package classe.classefinal;

public class EqualsHashCode {

	String nome;
	String email;

	
	// Chamando o equals, no código "u1.equals(u2)", utilizando "nome"("this.nome") eu estarei me referindo a u1.
    // Utilizando "outro.nome" estarei me referindo a u2.
	/* Lembrando que para acessar um membro ou objeto, ele nunca pode ser nulo!
	 * Neste caso(outro.nome.equals(this.nome)), "outro.nome" nunca poderá ser null.
	 * Se o codigo fosse "this.nome.equals(outro.nome)", "this.nome" não poderá ser null.
	*/
	
	public boolean equals(Object objeto) { 
		// A Classe "Object" é a raiz da hierarquia de classes. Cada classe tem "Object" como uma superclasse.
		// Todos os objetos, incluindo arrays, herdam os métodos desta classe.
		
			if(objeto instanceof EqualsHashCode) { 
				// Verificando se o objeto passado é uma instância de EqualsHashCode.
				/* Essa verificação precisa ser feita pelo fato de que não podemos dizer que um Usuario
				 *  é igual a alguma coisa que não tem nada a ver com um Usuario.
				 *   Um Usuario nunca será igual a uma Data ou a um Produto.
				 * O mesmo vale para EqualsHashCode.
				 */
				EqualsHashCode outro = (EqualsHashCode) objeto; // Casting de um Object para EqualsHashCodeAux.
				
				
				if(nome != null) {
					if(!nome.equals(outro.nome))
						return false;
				} else if(outro.nome != null)
					return false;
				
				if(email != null) {
					if(!email.equals(outro.email))
						return false;
				} else if(outro.email != null)
					return false;
				
				return true;
				
				
			} else {
				return false;
			}
	}
	
//	public boolean equals(Object obj) {
//		
//		if (this == obj) 
//			// Verifica se o objeto que está chamando o método (this) é exatamente o mesmo objeto que está sendo comparado (obj).
//			// Se os dois objetos são o mesmo (mesmo endereço de memória), retorna true.
//			return true;
//		
//		
//		if (obj == null) 
//			// Verifica se o objeto passado para comparação (obj) é null.
//			// Se for null, retorna false porque um objeto nunca pode ser igual a null.
//			return false;
//		
//		
//		if (getClass() != obj.getClass()) 
//			// Verifica se o objeto atual (this) é da mesma classe que o objeto passado para comparação (obj).
//			// Se os objetos não são da mesma classe, retorna false porque eles não podem ser considerados iguais.
//			return false;
//		
//		
//		EqualsHashCodeAux other = (EqualsHashCodeAux) obj;
//		// Casting do objeto passado para comparação (obj) para o tipo EqualsHashCodeAux.
//		
//	    // Os if's abaixo são para não deixar que tentemos acessar um objeto null(gerando um erro) na comparação.
	
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		
//		if (nome == null) {
//			if (other.nome != null)
//				return false;
//		} else if (!nome.equals(other.nome))
//			return false;
//		
//	return true;
//	
//	
//    }
	
}
