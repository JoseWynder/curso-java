package jpafinal;

public class JpaDefinitivo {

	// Data Mapper com JPA utilizando a implementação do Hibernate.
	
	// Vamos ver 2 padrões de projetos que tem relação com a parte de persistência.
	// Persistência é quando você vai pegar os dados da sua aplicação e persistir
	//  isso em algum banco de dados.
	// Obviamente nesse contexto é referente a banco de dados relacional.

	
	// 2 GRANDES PADRÕES DE PERSISTÊNCIA:
	
	
	// ACTIVE RECORD
	
	/*
	 * É muito encontrado em frameworks de PHP como laravel e também no próprio ruby on rails.
	 *  
	 * Imagine que você criou um objeto chamado "cliente" com uma série de
	 *  atributos e comportamentos.
	 * Esse "cliente" tem uma relação com a tabela "clientes" definida no banco de dados.
	 * Assim, você tem uma série de atributos que vão estar relacionados com algumas
	 *  colunas no banco de dados.
	 * Nessa situação, quando você tem o active record pattern, a própria
	 *  entidade, ou seja, o próprio objeto que tem relação com determinada tabela
	 *  do banco de dados, tem dentro dele todos os métodos responsáveis para persistir.
	 * É como se fosse um registro ativo. O próprio objeto de forma ativa tem os
	 *  métodos necessários para se inserir dentro do banco de dados.
	 * Normalmente isso é feito a partir de herança. Você faz com que determinado objeto
	 *  herde de uma classe que tenha todos os métodos utilizados para persistir.
	 *  
	 * Exemplo:
	 * 
	 *  Cliente c = ...;
	 *  c.save();
	 * 
	 *  Aqui você tem um método dentro de "c" responsável por salvar o objeto
	 *   dentro do banco de dados.
	 *  
	 *   ou
	 *   
	 *  Cliente.find(...);
	 * 
	 *  Aqui você passaria todos os filtros que você quer para obter um determinado
	 *   cliente no banco de dados.
	 *  
	 * Esse é o active record.
	 * Onde você tem o próprio objeto com todos os métodos para interagir
	 *  com a camada de persistência.
	 * Isso normalmente é feito a partir da herança.
	 * No Active Record você não precisa de mais nenhum outro padrão
	 *  para realizar a persistência.
	 */
	
	
	// DATA MAPPER
	
	/*
	 * Esse padrão funcionaria de forma em que cada objeto é mapeado para o banco de 
	 *  dados a partir de um arquivo xml, um arquivo json ou até uma annotation.
	 * Realizando o mapeamento do objeto e de seus atributos em uma tabela no banco de dados.
	 * Podendo ter 2 objetos sendo mapeados para 1 tabela assim como 1 objeto
	 *  sendo mapeado para mais de uma tabela.
	 * Tem também a questão dos relacionamentos e algumas outras coisas.
	 * Tudo é resolvido dentro do JPA e o padrão que está por traz disso é o Data Mapper.
	 * No Data Mapper eventualmente é necessário a utilização de um Data Access Object(DAO)
	 *  ou outro padrão para realizar a persistência dos dados.
	 */
	
	/* Nesses exercícios será utilizado a versão 5.4.8 do Hibernate.
	 * É utilizando um jpa-project que já vem com o arquivo de persistência xml.
	 * No arquivo instalado, dentro de hibernate -> lib -> required =
	 *  estão as mínimas bibliotecas necessárias para rodar o hibernate.
	 * Lembrando que também é necessário o arquivo de conexão do MySQL.
	 * Você consegue encontrar facilmente o arquivo de persistência .xml
	 *  já configurado na internet.
	 */
	
	// Esse nível de abstração maior do jpa traz também uma preocupação quando
	//  falamos do desempenho da aplicação. É importante o desenvolvedor ter um cuidado
	//  para não perder o controle do que está sendo feito por baixo dos panos.
	
	// No JPA utilizamos o JPQL(Java Persistence Query Language).
	// Não estaremos consultando tabelas e sim objetos.
	// Quem está convertendo o JPQL para SQL é o próprio framework.
	// Se o nome da tabela é "tb_clientes" e o nome da classe é "Cliente"
	//  você vai selecionar em cima de "Cliente", em cima da classe.
	
	// É muito importante entender sobre o ORM(Object Relational Mapper).
	
	// RELACIONAMENTOS EM O.O QUANDO FALAMOS DE ORM
	
	/*
	 * "->" representa um atributo.
	 * 
	 * 
	 * Relacionamento 1 para 1
	 * 
	 *   ClasseA   |   ClasseB
	 * 		   	   |   -> ClasseA
	 * 
	 * Bidirecional:
	 *  É evitado já que pode gerar inconsistências.
	 * 
	 *   ClasseA   |   ClasseB
	 * -> ClasseB  |   -> ClasseA
	 * 
	 * 
	 * Relacionamento 1 para n
	 *  No modelo E/R o tipo 1 sempre vai para o tipo n.
	 *  Sendo assim, a ClasseB tem que ter um atributo do tipo ClasseA.
	 * 
	 *     ClasseA     |   ClasseB
	 * 	  	   	       |   -> ClasseA
	 * 
	 * Bidirecional:
	 * 
	 *     ClasseA     |   ClasseB
	 *  List<ClasseB>  |   -> ClasseA
	 * 
	 * 
	 * Relacionamento n para n
	 * 
	 *     ClasseA     |   ClasseB
	 * 	List<ClasseB>  |   List<ClasseA>
	 * 
	 */
	
	/* 
	 * JPA - 
	 * @OneToOne
	 * @OneToMany <- @ManyToOne
	 * @ManyToMany
	 * 
	 */
	
	
	// JPA - CARREGAMENTO TARDIO(LAZY) E CARREGAMENTO APRESSADO(EAGER).
	
	/*
	 * Sempre que é uma relação "para 1", por padrão o jpa já traz as duas entidades.
	 * 
	 * Na relação "1 para 1" de Cliente com Assento:
	 * 	Sempre que você fizer uma chamada no Cliente, o jpa irá trazer o Assento
	 *  associado. Igualmente para Assento.
	 * 
	 * Na relação "n para 1" de Mãe e Filho:
	 *  Sempre que você fizer uma chamada no Filho, o jpa irá trazer a Mãe
	 *  associada. Porém, isso não ocorre quando você realiza uma chamada na Mãe.
	 *   
	 * Na relação "para 1" o jpa entende que não irá pesar já que é somente 1 registro.
	 * 
	 * Nesse cenário a relação vai ser "EAGER".
	 * No caso "para n" o relacionamento por padrão é "LAZY".
	 * 
	 * O ideal é que ao definir o atributo, você realize a verificação da necessidade
	 *  de obter esses dados juntos. Se na grande maioria das vezes em que é feita
	 *  uma chamada na Mãe você também precisa dos seus filhos, aí sim faz sentido
	 *  definir a lista como "EAGER". Caso você só precise em situações específicas,
	 *  o ideal seria manter como "LAZY" e quando precisar dos filhos você
	 *  realiza uma consulta jpql.
	 */
	
	
	// COMO É FEITO O ORM COM HERANÇA
	
	/*
	 * Existem 3 estratégias implementadas no jpa.
	 * 
	 * InheritanceType.SINGLE_TABLE:
	 *  Definir toda a estrutura de herança(1 ou mais classes) em apenas uma tabela.
	 * Ou seja, você vai ter todos os atributos dessas classes juntos dentro dessa tabela.
	 * Sendo assim, vai ser necessário ter vários campos marcados como nulo.
	 * 
	 * InheritanceType.TABLE_PER_CLASS:
	 * 	Uma tabela para cada classe concreta.
	 * Sendo assim, você terá campos duplicados entre as tabelas.
	 * 
	 * InheritanceType.JOINED:
	 *  Utilizando junções.
	 * Dessa forma você vai ter uma tabela com todos os elementos comuns e somente
	 *  os atributos unicos de cada entidade estará na sua própria tabela.
	 * Nessa junção, a chave primária da tabela passa a ser uma FK na tabela que
	 *  representa a junção.
	 * A junção acaba sendo um pouco mais lenta já que é necessário realizar
	 *  junções nas consultas.
	 * 
	 */
	
	
	
	
}