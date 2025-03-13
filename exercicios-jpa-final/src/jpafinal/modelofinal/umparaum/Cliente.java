package jpafinal.modelofinal.umparaum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
//	@Column(name = "assento_id")
//	private Long assentoId;
	// Nesse caso você está trazendo as ideias do paradigma que o banco de dados
	//  segue e colocando dentro do seu mundo orientado a objetos.
	// Essa não é uma estratégia interessante.

	// Dessa forma eu tenho acesso ao id do assento e todos os seus atributos.
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	// Com a annotation OneToOne é criado automaticamente dentro da tabela "cliente" o
	//  atributo "assento_id". Que é exatamente a FK que vai vir na tabela assento.
	@JoinColumn(name = "assento_id", unique = true)
	// Para garantir a relação 1 para 1 sem que haja repetição em ambos os campos.
	// @JoinColumn é uma annotation específica para mapear campos que representam
	//  junção entre tabelas.
	private Assento assento;

	public Cliente() {

	}

	public Cliente(String nome, Assento assento) {
		this.nome = nome;
		this.assento = assento;
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

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

}
