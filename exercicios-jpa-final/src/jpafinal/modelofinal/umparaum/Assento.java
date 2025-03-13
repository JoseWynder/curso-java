package jpafinal.modelofinal.umparaum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assentos")
public class Assento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@OneToOne(mappedBy = "assento")
	// Necessário para gerar uma relação bidirecional.
	// Sem o "mappedBy" será criado um atributo dentro de assento chamado "cliente_id".
	// Será criado a coluna nas duas tabelas, o que não é muito interessante.
	// Não existe relacionamento bidirecional no banco de dados! Você até pode fazer,
	//  mas sem duvidas vai violar os principios do banco de dados.
	// Para dizer ao jpa que essa se trata de uma relação bidirecional que já foi
	//  mapeado em outro atributo se utiliza a anotação "mappedBy".
	// O "mappedBy" vai dizer qual é o nome do atributo que faz parte dessa relação.
	// Interpretando o código: A relação 1 para 1 está mapeada
	//  no atributo "assento" que pertence a classe "Cliente".
	private Cliente cliente;

	public Assento() {

	}

	public Assento(String nome) {
		this.nome = nome;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
