package jpafinal.modelofinal.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos", schema = "curso_java")
	/* Setando o nome e definindo explícitamente o schema que está sendo utilizado.
	 * Você também consegue definir o schema através do Entity Manager.
	 * Definindo nas unidades de persistência qual é o banco sem precisar colocar isso fixo
	 *  dentro da entidade. É preferivel já que se por algum motivo alguém alterar o nome do
	 *  schema do banco de dados, isso irá gerar problemas.
	 * Então essa não é uma estratégia tão interessante. */
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_nome", length = 120, nullable = false)
	/* Se o jpa for responsável por gerar o banco, ele vai gerar como foi definido aqui.
	 * Caso ele não seja o responsável, o que vai valer é o que está no banco de dados.
	 * Não é aplicado nenhum tipo de validação, embora exista o validation(javax.validation).
	 * O validation é uma api do java que tem todo um conjunto de annotations para auxiliar
	 *  na aplicação de validações básicas como a de obrigatoriedade, range, ...
	 * As annotation auxiliam na documentação já que só de olhar você sabe que lá
	 *  no bando o campo nome tem um tamanho de 120 caracteres.
	 * Quando você vê uma annotation é como se de certa forma fosse um comentário.
	 * Sendo assim, mesmo que você não use o jpa para gerar o banco de dados, colocar
	 *  essas informações pode ser interessante no ponto de vista você de documentação.  */
	private String nome;
	
	@Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
		// Precision define quando digitos pode ter o número.
		// Scale define a precisão das casas decimais.
	private Double preco;
	
	public Produto() {
		
	}
	
	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
