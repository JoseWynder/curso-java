package br.com.cod3r.exerciciossbfinal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Cliente;
import br.com.cod3r.exerciciossb.model.entities.Produto;
import jakarta.validation.Valid;

public class ExerciciosSbDefinitivo {
	
	/* O Spring Boot faz parte do conjunto de frameworks da Spring.
	 * A Spring surgiu como alternativa para o Java Entreprise Edition(Java EE).
	 * Uma forma mais simples e leve para se trabalhar com recursos voltados para empresas.
	 *  Como Autenticação, persistência, ... 
	 */
	
	/*
	 * O Spring Boot gera para você uma aplicação standalone(autônoma).
	 * Uma aplicação onde você consegue startar ela a partir de um simples método main.
	 *  
	 * O método main será usando para inicializar um servidor, um servidor embarcado.
	 * Antigamente, o processo de configuração para utilizar Java na Web era muito complexo.
	 * Aqui não, dentro do Spring você já recebe todo esse trabalho de configuração a pronto acesso.
	 * Você simplesmente inicia a sua aplicação utilizando o método main.
	 * Assim, você já tem um servidor web rodando, sem se preocupar com a configuração.
	 */
	
	
	// CRIANDO O PROJETO
	
	/*
	 * Preencher o formulário do projeto em "start.spring.io".
	 * Project: Maven
	 * Group: Domínio da empresa.
	 * Artifact: Identificador do projeto.
	 * Dependencies: JPA, MySQL, Security, DevTools, Web, ...
	 * 
	 * Baixar o .zip do projeto.
	 * Descompactar e, de preferência, coloca-lo dentro do workspace.
	 * 
	 * Importe o projeto no Package Explorer. Como "Existing Projects into Workspace", ...
	 * No nosso caso será um "Existing Maven Projects".
	 * O Maven já traz algumas depedências necessárias.
	 */
	
	// VISÃO GERAL - MAVEN
	
	/*
	 * "pom.xml":
	 *  É um arquivo de configuração do maven que traz algumas configurações importantes.
	 *  
	 *  - INF. PROJETO
	 *  
	 *  - DEPEDÊNCIAS DO PROJETO
	 * 	 Descrição das dependências. Como parte do processo, o maven lê esse arquivo .xml e baixa
	 *   as dependências definidas lá dentro.
	 *   
	 *  - PLUGINS*
	 * 
	 *  - GERENCIADOR DAS DEPENDÊNCIAS ---------------------------- REPOSITÓRIO
	 *   O gerenciador vai procurar e baixar os arquivos de dependências em um repositório na nuvem.
	 *   Na sua grande maioria são arquivos ".jar(Java Archive)".
	 *  
	 *  - PLUGINS(CICLO DE VIDA(PROCESSO DE BUILD DA APLICAÇÃO(DEPLOY)))
	 *  
	 * 	 	COMPILAÇÃO -> TESTE -> INSTALAÇÃO
	 * 
	 * 	 Esses plugins vão ser configurados para entrar em determinadas fases.
	 * 	 Dentro do arquivo "pom.xml" você pode colocar novos plugins, código que serão executados
	 *    durante o ciclo de vida. Para automatizar processos, rodar um teste de cobertura, ...
	 *    
	 */
	
	
	/*
	 * Você inicializa o projeto através da classe que contém a anotation "@SpringBootApplication".
	 * Utilizado o método estático "SpringApplication.run()",
	 *  passando a classe "...SpringApplication.class" e o "args" do main.
	 * Por padrão é utilizado a porta 8080. Através do servidor Tomcat.
	 * 
	 */
	
	
	// PRATICA
	
	/*
	 * A primeira coisa a se fazer é anotar a classe "ExemploController" para que o Spring Boot
	 *  considere essa classe como controlador do tipo rest.
	 */
	
	/*
	 * @RestController é usada para criar controladores que manipulam requisições HTTP e retorna dados
	 *  diretamente como resposta, em vez de renderizar uma view.
	 *  
	 * Ela é uma combinação de duas outras annotations: 
	 * 
	 * @Controller - Indica que a classe é um controlador Spring, que pode lidar com requisições HTTP.
	 * @ResponseBody - Indica que o valor de retorno dos métodos do controlador deve ser serializado
	 *  diretamente para o corpo da resposta HTTP, geralmente como JSON ou XML.
	 * 
	 * Ao usar @RestController, você não precisa adicionar @ResponseBody em cada método individualmente.
	 * Todos os métodos dentro de uma classe anotada com @RestController retornam dados diretamente
	 *  no corpo da resposta HTTP.
	 * 
	 * Ela é comumente usada em APIs RESTful para retornar dados JSON(JavaScript Object Notation) ou XML.
	 */
	
	@RestController
	@RequestMapping("/clientes")
	public class ExemploController {

		@GetMapping("/qualquer")
		public Cliente obterCliente() {
			return new Cliente(28, "Pedro", "123.456.789-00");
		}
		
		@GetMapping("/{id}")
		public Cliente obterClientePorId1(@PathVariable int id) {
			return new Cliente(id, "Maria", "987.654.321-00");
		}
		
		@GetMapping
		public Cliente oberClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id) {
			return new Cliente(id, "João Augusto", "111.222.333-44");
		}
	}
	
	
	// Formato JSON
	
	/*
	 * JSON é um formato textual! É um formato para transferir informações entre sistemas.
	 * 
	 * Até em casos que você tenha uma aplicação onde, por exemplo,
	 *  o back-end é feito em Java e o front-end em react, angular, view, ...
	 * 
	 * Esse é um cenário muito comum.
	 * Você ter a sua aplicação no back-end, a sua API, seus Web Services desenvolvidos com Java e você ter uma aplicação
	 *  front-end criada em outra linguagem, como, por exemplo, em Java Script.
	 * Aqui nós temos duas aplicações. Embora no seu negócio seja uma aplicação só, são duas aplicações distintas.
	 * E você usa muito frequentemente de JSON para transferir as informações da aplicação back-end para o front-end.
	 * 
	 * O mesmo serve para integrar aplicações de diferentes tecnologias.
	 * Você tem uma aplicação em PHP, uma aplicação em Python, em Java, e essas aplicações precisam se comunicar.
	 * Um dos formatos mais famosos de interoperabilidade entre as aplicações, entre os dados, é o formato JSON.
	 * 
	 * Existem vários outros formatos como, por exemplo, o formato YMAL ou até o próprio XML.
	 * 
	 */
	
	
	// HTTP
	
	/*
	 * ...Conteúdo do capítulo de Conceitos sobre Web...
	 * 
	 * 
	 * - GET
	 *   Usado para obter/ler informações do servidor. O GET é o método mais utilizado da web.
	 *   Via de regra esse método GET não é para causar nenhum tipo de alteração ou efeito colateral no servidor.
	 *   É possível realizar essa requisição para alterar o servidor, mas, você está indo contra a semântica do método GET.
	 *  
	 *  
	 * - POST/PUT/PATCH/DELETE
	 *   O POST é usado para submeter ou enviar informações ao servidor.
	 *   Dentre esses quatro métodos, o POST é o mais usado.
	 *  
	 *  Para realizar alterações é utilizado o PUT ou o PATCH.
	 *   A diferença entre eles é que o PATCH é usado para realizar alterações parciais no servidor.
	 *   Enquanto que o PUT é usado quando você quer realizar uma alteração total.
	 *   Via de regra é mais comum você utilizar o PUT dentro de uma API RESTful.
	 *   Olhando para um cenário de mercado, você acaba utilizando mais frequentemente o PUT do que o PATCH.
	 *   Então, normalmente você vai trabalhar apenas com o PUT. Sem fazer essa diferenciação entre
	 *    uma alteração parcial e total.
	 *   
	 *  O DELETE é responsável por realizar a exclusão.
	 *  
	 *  Como já foi dito, essa questão dos métodos tem uma idéia de semântica, de significado. Não necessariamente você
	 *   precisa para excluir, utilizar o DELETE. Já que a exclusão é feita dentro da sua aplicação.
	 *   Esses métodos estão funcionando entre o browser e a aplicação spring boot, ou seja, o seu servidor.
	 *   Eles funcinam como forma de comunicação entre esses dois computadores na internet.
	 *   O que a sua aplicação faz com essa requisição, não tem nenhuma relação direta com o tipo de método http
	 *   que você utilizou. Você pode usar o método DELETE para ler informações no servidor.
	 *  
	 *   Quanto mais você manter essa consistência, no que diz respeito ao significado de cada método,
	 *   mais aderente você vai estar ao padrão RESTful..
	 *  
	 *   Como exemplo, existe uma tecnologia chamada GRAPHQL. Ela surgiu como alternativa a uma API do tipo RESTful.
	 *   O GRAPHQL utiliza o método POST para inserir, alterar e excluir um registro. Para ler, ele usa o GET.
	 *   Ou seja, o GRAPHQL usa apenas o método POST e GET. Já que não existe essa "amarração".
	 *   
	 *   
	 *  - OPTIONS
	 *    Vamos supor que você tenha uma url chamada "/ola". 
	 *    Essa url vai responder tanto requisições do tipo GET quando do tipo POST.
	 *    Você realizar uma requisição do tipo OPTIONS encima da url "/ola" vai retornar quais são os
	 *     métodos http que aquela url suporta.
	 *   
	 *   
	 *  - TRACE
	 *    O TRACE ser para fazer, como se fosse uma "requisição de teste"(Loopback).
	 *    O método TRACE é usado principalmente para fins de depuração.
	 *  
	 *  
	 *  - HEAD
	 *    O HEAD é uma requisição muito parecida com o GET.
	 *    Quando você faz uma requisição com o GET, ele retorna o corpo da resposta.
	 *    Quando você faz uma requisição com o HEAD você vai ter a mesma resposta, só que sem o conteúdo.
	 *    Então, você pode usar uma requisição do tipo HEAD quando você quer verificar
	 *     que determinada url está funcionando.
	 *  
	 */
	
	
	// MVC NO SPRING - CONTEXTUALIZAÇÃO
	
	/*
	 * O protocolo HTTP é baseado em requisição e resposta.
	 * Tudo começa a partir do browser. 
	 * É feita uma requisição e lá no servidor vai ter uma aplicação utilizando o Spring Boot.
	 * Antes de entrar na nossa aplicação, quem vai tratar a requisição é o servidor que está embutido.
	 * Por exemplo, o servidor Tomcat rodando na porta 8080.
	 * Quando chega no Tomcat ele vai passar a requisição para o Front Controller.
	 *  No caso do Spring, é um cara chamado DispatcherServlet.
	 *  
	 * Essa requisição HTTP tem dentro dela uma URL. A partir da URL e das anotações definidas nos controllers,
	 *  o front controller do spring vai ser capaz de direcionar as requisições para o controller correto.
	 * 
	 * Quando você está trabalhando com API e está retornando dados, por exemplo, em JSON, na teoria você não vai
	 *  precisar utilizar a VIEW.
	 * Nesse caso, como estamos trabalhando com um cenário mais moderno, a gente acaba desenvolvendo uma API Spring Boot
	 *  retornando apenas JSON. A sua aplicação front-end, muitas vezes fica em outra aplicação.
	 * Existe, sim, demanda para construir aplicações server-side, uma aplicação onde as páginas são geradas no servidor.
	 *  Mas, por norma, hoje em dia as aplicações trabalham muito mais com essa parte de JS.
	 * 
	 */
	
	/*
	 * Definindo algumas depêndencias:
	 * 
	 * <dependency>                                               
	 *     <groupId>org.springframework.boot</groupId>      
	 *     <artifactId>spring-boot-starter-data-jpa</artifactId>
	 * </dependency>                                                              
     * <dependency>                                               
     *     <groupId>mysql</groupId>                             
     *     <artifactId>mysql-connector-java</artifactId>        
     *     <version>8.0.32</version>                            
     * </dependency>
     * <dependency>                                               
     *     <groupId>org.springframework.boot</groupId>            
     *     <artifactId>spring-boot-starter-validation</artifactId>
     * </dependency>                                              
     * 
     *         
     * Configurando arquivo.properties:
     * 
     * spring.datasource.url=jdbc:mysql://localhost:3306/springboot               
     * spring.datasource.username=root                                            
     * spring.datasource.password=12345678                                        
     *                                                                            
     * spring.jpa.hibernate.ddl-auto=update                                       
     * spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
     * 
     */ 
       
	
	/*
	 * A gente tem o CONTROLLER como sendo as classes que vão controlar o fluxo.
	 * O CONTROLLER não tem o papel de validar dados, a não ser que seja de forma automática.
	 * Muito menos de, por exemplo, executar regras da sua aplicação, as regras de negócio.
	 * Vamos colocar todas essas questões como, as validações, regras de negócio e acesso a dados, dentro do MODEL.
	 * 
	 * Então, o MODEL, além de ter as entidades, que são as partes que você vai mapear para o banco de dados,
	 *  você também vai ter a parte de acesso a dados, no caso usaremos o repository para isso.
	 * Também eventualmente teremos classes conhecidos como services ou applicationServices, que são classes que
	 *  vão ser responsáveis por validar/aplicar as regras da sua aplicação.
	 * Nesse modelo que o Java adota, as entidades são mais "magras". Sem a presença de tantas regras de negócio
	 *  dentro delas.
	 * Você eventualmente até pode colocar. Inclusive, alguns atores defendem você colocar as regras de negócio
	 *  dentro das suas entidades. Mas, por norma, não é um padrão tão utilizado dentro do Java.
	 * Isso depende muito da cultura da linguagem, do tipo de framework que você vai utlizar.
	 * Aqui vamos usar um modelo mais alinhado com o mercado.
	 * 
	 * 
	 * Para a classe "ProdutoRepository"
	 * 
	 * Um repositório de dados pode ser:
	 * 
	 * Um arquivo,
	 * um arquivo de texto,
	 * uma planilha no excel,
	 * um banco de dados,
	 * ...
	 * 
	 * Então, na verdade, a ideia do repositório é simplesmente você criar métodos de alto nível quem
	 *  vão abstrair todo o acesso à dados.
	 * Assim como um DAO(Data Access Object). A diferença é que o DAO foca mais na parte da implementação e o 
	 *  repositório de definir a interface de como você vai abstrair o acesso a dados.
	 *  
	 * 
	 */
	
	
// -------------------------------------------------------------------------------------------------------------
       
	
	// PRODUTO REPOSITORY NA CAMADA MODEL: 
	 
	public interface ProdutoRepository 
	extends CrudRepository<Produto, Integer>, PagingAndSortingRepository<Produto, Integer> {
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
//	findByNomeContaining
//	findByNomeIsContaining
//	findByNomeContains
//	
//	findByNomeStartWith
//	findByNomeEndsWith
//	
//	findByNomeNotContaining
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String name);

}
	
	
// -------------------------------------------------------------------------------------------------------------
	
	
	// CRIAÇÃO DE MÉTODOS NO SPRING BOOT
	
	/*
	 * O conceito de convenção é bem forte no Spring Boot. Principalmente para essa finalidade.
	 * Todos os métodos que começam com "find" o spring entende que aquele método vai realizar uma pesquisa.
	 * A equipe do Spring Boot definiu uma série de convenções que vão nos ajudar a criar métodos sem a gente
	 *  necessáriamente precisar implementar esses métodos.
	 */
	
	
// -------------------------------------------------------------------------------------------------------------
	
	
	// PRODUTO CONTROLLER NA CAMADA CONTROLLER:
	
	@RestController
	@RequestMapping("/api/produtos")
	public class PodutoController {
		
		@Autowired
		private ProdutoRepository produtoRepository;
		
		@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
		public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
			produtoRepository.save(produto);
			return produto;
		}
		
		@GetMapping
		public Iterable<Produto> obterProdutos() {
			return produtoRepository.findAll();
		}
		
		@GetMapping(path = "/nome/{parteNome}")
		public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
//			return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
			return produtoRepository.searchByNameLike(parteNome);
			
		}
		
		@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
		public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
			if(qtdePagina >= 5) qtdePagina = 5;
			Pageable page = PageRequest.of(numeroPagina, qtdePagina);
			return produtoRepository.findAll(page);
			
		}
		
		@GetMapping(path="/{id}")
		public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
			return produtoRepository.findById(id);
		}
		
		@DeleteMapping(path = "/{id}")
		public void excluirProduto(@PathVariable int id) {
			produtoRepository.deleteById(id);
		}
	}
	
	
// -------------------------------------------------------------------------------------------------------------
	
	
	
	// INVERSION OF CONTROL
	
	// INJEÇÃO DE DEPENDÊNCIA(dependency injection)
	
	/*
	 * Imagine que você tenha uma classe A.
	 * Essa classe A precisa de uma instância da classe B para funcionar.
	 * O mais natural nesse cenário é a classe A instânciar a classe B.
	 * Ou seja, em algum momento dentro do algoritmo definido na classe A,
	 *  você vai ter algo como: "
	 *  	B b = new B();
	 *  ".
	 * 
	 * Em outras palavras, quem é o responsável por obter uma instância de B? A classe A.
	 * Esse é um tipo de cenário em que o CONTROLLER é da forma como todo mundo espera.
	 * 
	 * Bem, agora, vamos imaginar que essa classe B tenha uma complexidade relativamente grande
	 *  para você criá-la.
	 * Você precisa passar uma série de parâmetros, você talvez precise pegar uma conexão com o banco de dados, ...
	 * Um processo trabalhoso e chato. Você precisa depender de outras classes para conseguir instânciar
	 *  a classe B.
	 * Não seria mais interessante você receber uma instância de B sem se preocupar com esses detalhes?
	 * Até se ela for uma classe simples de ser criada, ainda assim seria interessante recebê-la de mão beijada.
	 * 
	 * Foi dessa questão que surgiu a ideia de você colocar um terceiro agente, responsável por criar uma instância
	 *  e colocar essa instância dentro de uma classe.
	 *  
	 * Injeção de dependência:
	 * 
	 * Nós temos uma classe A que precisa de uma determinada classe B.
	 * 
	 * Obviamente você vai precisar declarar em algum momento que A precisa de B.
	 *  B b; <- Dentro de A.
	 * Após isso, você simplesmente marca esse atributo como "@Autowired".
	 * Ou seja, eu quero que seja inserido uma instância desse tipo.
	 * 
	 * Quem vai realizar isso? O framework responsável pela injeção de dependência.
	 * No caso, estamos usando o Spring.
	 * 
	 * O Spring gerência essa classe A, já que ela é marcada como "@RestController".
	 * Por ser uma classe que já foi criada pelo Spring, ou seja, quem criou um @RestController não foi a gente.
	 * Se você prestar atenção na nossa aplicação, em nenhum momento nós fizemos um "new ProdutoController".
	 * Todos os CONTROLLERS que nós usamos foram criados e instânciados pelo Spring.
	 * 
	 * Como foi que ele criou esses objetos? 
	 *  O Spring foi capaz de ler o nosso código, a partir do classpath, ele passou por todas as classes,
	 *   conseguiu detectar as anotações via reflection, lendo as anotações ele descobriu que determinadas classes
	 *   eram CONTROLLERS e que ele precisava instânciar essas classes.
	 *   
	 * Como o Spring é o responsável por criar um CONTROLLER, ele é capaz de ler as outras anotações e ver que é
	 *  necessário injetar algum objeto para preencher determinado atributo da classe.
	 * Ele só é capaz de fazer isso por conta que ele gerência essa classe.
	 * 
	 * 
	 * 
	 */
	
	// CONCEITO SIMPLES SOBRE SOFT DELETE
	
	/*
	 * Um soft delete é quando você não deleta fisicamente o registro no banco de dados.
	 * Criando uma espécie de exclusão lógica.
	 * É como se você criasse uma coluna no banco de dados chamada "deletado".
	 * Se estiver 0 é por que não está deletado, se você atualizar a coluna para 1,
	 *  significa que esse registro foi deletado.
	 * As vezes também é utilizado um campo de data, como por exemplo, um campo "deletado em".
	 * Se estiver com a data setada significa que aquele registro foi deletado, naquela data,
	 *  e caso o campo esteja nulo, significa que o registro ainda é válido.
	 * Muita gente utiliza. Até por que, excluir um registro do banco de dados, principalmente quando você tem uma
	 *  série de relacionamentos é uma tarefa um tanto quanto complicada.
	 * Você tem que excluir todos os relacionamentos, todas as dependências, ...
	 * Por isso, acaba sendo muito comum trabalhar com soft delete.
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
}                                            
     
    