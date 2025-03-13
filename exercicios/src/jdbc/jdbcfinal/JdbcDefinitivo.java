package jdbc.jdbcfinal;

public class JdbcDefinitivo {

	
	// JDBC - Java Database Connectivity.

	/* 
	 * JBDC - Conectividade de banco de dados com java.
	 * JDBC é uma série de funcionalidades(interfaces e classes) que vão ajudar a interagir
	 *  com o banco de dados.
	 * JDBC define um conjunto de interfaces. Ou seja, quais são os métodos que precisam estar
	 *  presentes quando você for construir, por exemplo, um driver, que é exatamente uma
	 *  biblioteca que vai te ajudar a ter a conectividade com determinados bancos de dados.
	 * Por exemplo, vou implementar a minha funcionalidade usando o MySQL, então eu vou baixar
	 *  o driver do MySQL que implementa as interfaces definidas na api do jdbc. E ai a gente
	 *  consegue interagir com o MySQL. Se eu baixar um driver do PostgreSQL, eu vou utilizar
	 *  as mesmas interfaces, para interagir com o banco de dados PostgreSQL.
	 * Isso vale para outros bancos como o Oragle, SQLserver da microsft, ...
	 */
	
	
	// CONCEITO SOBRE PORTAS
	
	/* 
	 * A porta tem relação com um processo. 
	 * Quando você vai fazer comunicação em rede, ou seja, quando você precisa acessar um 
	 *  serviço que roda em outra máquina, você usa um endereço IP para acessar.
	 * Eventualmente você vai utilizar um endereço como www.cod3r.com.br, e esse nome será
	 *  resolvido pelo dns.
	 * Bem, no final das contas cada máquina dentro de uma rede(usando o protocolo TCP/IP)
	 *  vai ter um IP.
	 * Quando você manda uma informação de uma determinada máquina que tem o IP x para uma
	 *  outra máquina que tem um IP y, essa comunicação não é suficiente.
	 * Quando chega uma informação não é suficiente você dizer que chegou uma informação
	 *  para a máquina! Ok, chegou uma requisição, mas qual processo vai atender a essa
	 *  requisição? Será que é um jogo, um browser, uma aplicação de email que está rodando?
	 *  Tudo vai depender de qual é o processo que está rodando na porta.
	 *  Ou seja, quando você manda uma requisição de uma máquina para a outra, a porta está
	 *  embutida.
	 * No caso do MySQL, a porta padrão quando você não informa nenhuma porta é a 3306.
	 * Se você tiver colocado uma porta diferente da 3306, no momento em que você for
	 *  conectar você precisa informar qual foi a porta.
	 * Da mesma forma que no protocole HTTP, por padrão ele atende na porta 80.
	 * Se você não estiver rodando na porta 80 você vai ter que informar a porta.
	 * Cada protocolo, cada tipo de aplicação tem uma porta padrão.
	 * 
	 */
	
	
	// ARQUIVO DE PROPRIEDADE (.PROPERTIES)
	
	/*
	 * Você pode externalizar o arquivo para alguma pasta predeterminada.
	 * Como não tem um arquivo próprio .properties, criei um File.
	 * nome_arquivo.properties
	 * Um arquivo .properties é um arquivo textual e com a estrutura chave valor.
	 * O bom é que por ser um arquivo textual, você consegue altera-lo de qualquer local.
	 * Após criar o .properties e fazer com que a classe responsável por gerar as conexões
	 *  passe a consumir os dados a partir desse arquivo.
	 * Para isso, utiliza-se a classe chamada "Properties" de java.util.
	 * Ela é exatamente uma classe que lê esse arquivo e captura a
	 *  chave e valor de uma forma mais intuitiva.
	 * Não é uma boa prática você colocar as informações de conexão diretamente,
	 *  de forma hardcoded dentro do seu código.
	 * Para quem usa github você pode colocar esse arquivo no .gitignore.
	 * Não é interessante ter esse arquivo em repositório quando
	 *  se está trabalhando em um time.
	 */
	
	
	// MAPEAMENTO DO BANCO DE DADOS EM OBJETOS
	
	/*
	 * É exatamente nesse problema que o JPA junto com a implementação do Hibernate entra.
	 * Que é um framework de mapeamento objeto relacional. Ou seja, ele faz o relacionamento
	 *  entre o mundo do banco de dados(entidade relacionamento) com o mundo de orientação
	 *  a objeto. Esse é exatamente o conceito de ORM(Object-relational mapping).
	 * No jdbcDefinitivoMain tem um exemplo simples de como criar um objeto e pegar
	 *  o ResultSet do JDBC e jogar dentro de um objeto.
	 * 
	 */
	
	private int codigo;
	private String nome;

	public JdbcDefinitivo(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	// PADRÃO DAO (Data Access Object) - Objeto de acesso a dados.
	
	/*
	 * O objetivo é isolar todo o código de acesso a dados fornecendo para a aplicação
	 *  métodos de mais alto nível de fácil chamada.
	 * No caso do JPA que já é de bem alto nível, o padrão não é necessário.
	 * No caso do JDBC o DAO é práticamente um requisito.
	 * A ideia é criar métodos de mais alto nível que vai te ajudar na hora de inserir,
	 *  alterar, excluir, consultar, ...
	 * Utilizando uma série de funcionalidades que complementa o acesso a banco de dados.
	 * Quando você não usa um padrão de projeto como o DAO, o que acontece é que você vai
	 *  ter as regras da sua aplicação como as regras de negócio, as validações,
	 *  os cálculos misturado com o acesso ao banco de dados. Ou seja, uma hora você
	 *  faz um select e pega os dados, joga esses dados em um objeto para realizar
	 *  um cálculo, ai depois você precisa fazer outro select para
	 *  pegar outra coisa do banco de dados, converter isso para um objeto, ...
	 * Você fica misturando a parte de código de infraestrutura com os códigos
	 *  relacionado ao negócio do seu sistema.
	 * A ideia de você trabalhar com o DAO é você tentar separar os objetivos.
	 * Com os DAOs você pode utilizar varias coisas para ajudar na implementação
	 *  como generics, reflexion, annotation, e outras coisas.
	 */
	
}
