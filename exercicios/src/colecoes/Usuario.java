package colecoes;

public class Usuario {

	public String nome;
		// public por causa que eu mudei "CollectionsDefinitivo" para outro pacote.
	String email;
	
	public Usuario(String nome){ // Precisa ser público para EqualsHashCode do package "classe" acessar.
		this.nome = nome;
	}

	public String toString() { // Para retornar o nome do Usuario quando for chamar o print().
		
		return "meu nome é " + this.nome + ".";
	}
	
	@Override
	public int hashCode() { // HashCode eclipse
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { // Equals eclipse
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
