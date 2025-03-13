package jpafinal.modelofinal.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

// @Entity e @Id são as duas annotation que toda entidade obrigatoriamente precisa ter.
// Após definir a estrutura da classe é necessário referenciá-la no "persistence.xml".

@Entity
// Estou dizendo que essa classe está mapeada para uma entidade no banco de
// dados.
public class Usuario {

	@Id
	// Define a chave primária(PK).
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue diz que o valor desse atributo vai ser auto incremento.
	// Dentro dele você tem algumas estratégias de geração como "AUTO",
	//  "IDENTITY", "SEQUENCE" e "TABLE". Nesse caso não é utilizado uma
	//  "SEQUENCE" porque ela pode ser compartilhada com outras entidades.
	// Dessa forma a tabela "hibernate_sequence" não é criada porque que
	//  o campo "id" já é inserido como auto incremento.
	private Long id;

	private String nome;
	// Por padrão, todo atributo que pertence a uma classe é
	// mapeado para uma coluna no banco de dados.
	// Quando nada é informado alguns padrões são aplicados.

	private String email;

	@Transient
	// O atributo não é mapeado para o banco de dados.
	// Isso geralmente acontece quando você tem um atributo calculado.
	// Ex:
	// Você tem um atributo "preco", um atributo "desconto" e outro
	//  que representa o preço final chamado "precoComDesconto".
	private boolean naoVai;

	public Usuario() {
	}

	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNaoVai() {
		return naoVai;
	}

}
