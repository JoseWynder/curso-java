package jpafinal.modelofinal.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Double nota;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	// Relação de junção de tabelas.
	@JoinTable(
		name = "atores_filmes",
		// joinColumns está relacionado com a classe atual.
		// A coluna que ela se referência dentro da tabela "filme" é a coluna "id".
		joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
		// inverseJoinColumns é o que vem da outra entidade chamada "Ator".
		// A coluna que referência a tabela "ator" se chama "id".
		inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id") )
	private List<Ator> atores;
	
	public Filme() {

	}

	public Filme(String nome, Double nota) {
		this.nome = nome;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		if(atores == null) {
			atores = new ArrayList<>();
		}
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	public void adicionarAtor(Ator ator) {
		// Método para lidar com a relação bidirecional.
		if(ator != null && !getAtores().contains(ator)) {
			getAtores().add(ator);
			if(!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}
}
