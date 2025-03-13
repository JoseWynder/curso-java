package modularidade;

public class ModuloDefinitivo {

	/*
	 * Esse recurso surgiu no JDK 9.
	 * Antes, só existiam 4 níveis de encapsulamento(public, protected, default, private).
	 * 
	 * Quando você gera uma aplicação em java, você gera um arquivo .jar(Java Archive). 
	 * Dentro do arquivo .jar vão estar todas as classes java compiladas para bytecode,
	 *  gerando o arquivo .class e lá dentro vai estar encapsulado, agrupado em um
	 *   grande arquivo várias classes do seu projeto. 
	 * Antes do JDK 9, quando você criava uma classe pública, independente dessa classe estar
	 *  em um jar ou outro jar, ser uma biblioteca ou mesmo ser uma classe interna do 
	 *  próprio java(JVM), essa classe pública poderia ser acessada por todo mundo.
	 * Então, era muito difícil você dividir a sua aplicação em múltiplos pacotes e não 
	 *  recorrer a classes públicas. Se você precisar acessar uma classe a partir de 
	 *  outro pacote, você necessariamente tinha que tornar essa classe pública para 
	 *  todo o mundo, não apenas para o seu projeto.
	 * 
	 * Com o sistema de módulos você consegue ter um nível de encapsulamento melhor,
	 *  ele te ajuda a construir uma arquitetura muito mais saudável.
	 */
	
	// MODULOS VS ENCAPSULAMENTO
	
	/*
	 * Sem módulos - 
	 * Considerando:
	 * 
	 *  Projeto "A" depende do "B".
	 *   
	 *  +-------+        +-------+
	 *  |   A   |  ---?  |   B   |
	 *  |-------|        |-------|
	 *   
	 *  O projeto B tem 2 pacotes. Pacote "x" e "y".
	 *  
	 *  +-------+        +-------+
	 *  |   A   |  ---?  |   B   |
	 *  |-------|        |-------|
	 *  |       |        | ⊞-̶x   | não public
	 *  |       |		 | ⊞-ɏ   | não public
	 *  +-------+		 +-------+
	 *  
	 *  Você quer que apenas o pacote "x" fique visível para a aplicação "A".
	 *  Ou seja, a aplicação "A" acessa somente arquivos que pertencem ao pacote "x".
	 *  Para isso, as classes do pacote "x" precisam ser públicas.
	 *  
	 *  +-------+        +-------+
	 *  |   A   |        |   B   |
	 *  |-------|        |-------|
	 *  |       |  --->  | ⊞ x   | public
	 *  |       |		 | ⊞-ɏ   | não public
	 *  +-------+		 +-------+
	 *  
	 *  Vamos supor que essas classes do pacote "x" comecem a aumentar e você quer
	 *   organizá-las de forma mais interessante, você quer as enviar ao pacote "y".
	 *  Mantendo dentro do pacote "x" todas as classes que o projeto "A" acessa.
	 *  Como o pacote "x" depende de algumas classes enviadas para o pacote "y",
	 *   você precisa que essas classes sejam públicas.
	 *  
	 *  +-------+        +-------+
	 *  |   A   |        |   B   |
	 *  |-------|        |-------|
	 *  |       |  --->  | ⊞ x   | public
	 *  |       |  ---!  | ⊞ y   | public
	 *  +-------+		 +-------+  
	 *   
	 *  Dessa forma você expõe o pacote "y" que era para ser um pacote interno do projeto "B".
	 *  Você definiu essas classes públicas para que a partir do pacote "x" você consiga acessá-las.
	 *  Mas, você não quer que seja permitido que o projeto "A" acesse diretamente o pacote "y".
	 *   
	 *  Quando você começa a "quebrar" as suas classes e organizá-las em sub pacotes,
	 *   automaticamente se você quiser que uma classe acesse membros de uma classe que está
	 *   em outro pacote, você precisa torná-la pública, e pública para qualquer um acessá-la!
	 */   
	 
	/*   
	 * Com módulos(JDK 9+) - Por padrão, nenhum pacote de um projeto é visível em outro.
	 * Considerando:
	 * 
	 *  Projeto "A" depende do "B".
	 *  
	 *  +-------+        +-------+
	 *  |   A   |  ---?  |   B   |
	 *  |-------|        |-------|
	 * 
	 *  O projeto B tem 2 pacotes. Pacote "x" e "y".
	 *  
	 *  +-------+        +-------+
	 *  |   A   |  ---?  |   B   |
	 *  |-------|        |-------|
	 *  |       |        | ⊞-̶x   | não public
	 *  |       |		 | ⊞-ɏ   | não public
	 *  +-------+		 +-------+
	 *  
	 * Quando você cria um módulo, você vai ter um arquivo .java chamado "module-info" e ele vai descrever
	 *  quais são os arquivos que estão dentro de "B" que serão visíveis para fora do projeto.
	 * Mesmo definindo as classes do pacote "y" como públicas elas não serão visíveis para fora do projeto.
	 *    
	 *  +-------+        +-------+
	 *  |   A   |  ---?  |   B   |
	 *  |-------|        |-------|
	 *  |       |        | ⊞-̶x   | public
	 *  |       |		 | ⊞-ɏ   | public
	 *  |       |		 |-info.j|
	 *  +-------+		 +-------+
	 * 
	 * Para que o pacote seja visível você precisa informar no "module-info.java".
	 * 
	 *  +-------+             +-------+
	 *  |   A   |             |   B   |
	 *  |-------|             |-------|
	 *  |       |     --->    | ⊞ x   | public
	 *  |       |       	  | ⊞-ɏ   | public
	 *  |-info.j| requires x  |-info.j| exports x
	 *  +-------+       	  +-------+
	 * 
	 * O sistema de módulos melhora a questão do encapsulamento e garante que não haja dependência cíclica.
	 * 
	 * Exemplo de dependência cíclica:
	 * 
	 * +-+     +-+     +-+       +-+      +-+     +-+     +-+     +-+
	 * |A| --> |B| --> |C| <-!-> |D|  ou  |A| --> |B| --> |C| --> |D|--+  ou  ...
	 * +-+     +-+     +-+       +-+      +-+     +-+     +-+     +-+  |
	 *                                     |                           |
	 *                                     +-------------!-------------+
	 * 
	 * 
	 * O sistema de módulos é um conjunto de pacotes que você insere no módulo e tem a possibilidade de dizer
	 *  o que ficará visível para fora do módulo e o que é necessário para aquele módulo funcionar.
	 * 
	 */
	
	
	/*
	 * Ao utilizar o sistema de módulos você pode dizer quais os módulos do JDK que você
	 *  vai precisar para a sua aplicação funcionar.
	 *  
	 * Você pode exportar o seu projeto como um Runnble JAR file.
	 * Runnble JAR file é um jar que dentro dele tem uma classe que tem o método main.
	 *  Ai você pode dizer qual a classe, qual o método main que vai ser usado como a
	 *  porta de entrada da sua aplicação.
	 * Ou você pode exportá-lo como um JAR file. Após exportá-lo você pode criar uma
	 *  pasta libs em um projeto e adicionar para o Build Path.
	 * Assim, eu passo a referenciar o arquivo jar que é correspondente a outro projeto.
	 * Eu não tenha uma relação direta com esse outro projeto, mas, eu exportei o jar
	 *  e fiz uma referência, de tal forma que eu poderia ter acesso as suas classes.
	 *  
	 * Na prática, o que você acaba fazendo quando vai para a produção é definir a
	 *  dependência a partir dos arquivos .jar. Assim como uma biblioteca.
	 *  
	 *  Porém, tem outra forma de você realizar essa dependência, através do ModulePath.
	 *  Configurando o Build Path e definindo a dependência no ModulePath.
	 */
	
	
	/*
	 * O único módulo importado de forma implícita é o "java.base".
	 * É dentro do módulo "java.base" que está o pacote "java.lang" e alguns outros.
	 * Não confunda! Um módulo agrupa um conjunto de pacotes e um
	 *  pacote agrupa um conjunto de classes.
	 *  
	 * Para gerar qualquer dependência entre projetos é preciso configurar o Build Path.
	 * 
	 * Ao exportar um pacote, os seus sub pacotes não serão compartilhados.
	 * 
	 * Se você quiser deixar visível um pacote:
	 * 	exports br.com.cod3r.app.calculo;
	 * 
	 * Se você quiser utilizar um pacote visível:
	 * 	requires app.calculo;
	 * 
	 * Imagine:
	 * 	module app.logging {
	 *   exports br.com.cod3r.app.logging; 
	 *  }
	 *  e
	 *  module app.calculo {
	 *   requires app.logging;
	 *   exports br.com.cod3r.app.calculo;
	 *  }
	 *  e
	 *  module app.financeiro {
	 *   requires app.calculo;
	 *  }
	 * 
	 * Agora considere que em uma das classes de "br.com.cod3r.app.calculo" tem
	 *  um método que retorna uma classe do tipo "logger" que pertence a
	 *   "br.com.cod3r.app.logging".
	 * Se dentro de financeiro você tentar acessar esse método irá ocorrer um erro.
	 * Já que o projeto financeiro não requer logging. Você não tem acesso a essa classe.
	 * Você até poderia colocar "requires app.logging;" dentro do módulo de financeiro,
	 *  mas, você está explicitamente dependendo de algo que você não depende diretamente.
	 * Para resolver essa situação você pode declarar dentro de cálculo que essa dependência
	 *  é transitiva para quem for usar esse módulo.
	 * Você diz utilizando um "requires transitive app.logging;" em cálculo e adicionando no
	 *  ModulePath a utilização de "app.logging".
	 * 
	 * Também existe o "exports br.com.cod3r... to app.f...".
	 * Dessa forma você exporta para um determinado módulo específico.
	 * 
	 * Declarar um módulo como "open" permite você realizar o processo de introspecção.
	 * Ou seja, usar o Java Reflection.
	 * O java reflection pode ser usado, por exemplo, para alterar dados privados de uma classe.
	 * Ao tornar um módulo como aberto, ele é aberto para todo mundo.
	 * Você também pode tornar um pacote específico como aberto utilizando a palavra "opens".
	 * Além de poder, utilizar o "to" para restringir para um módulo específico.
	 */
	
	
	/* 
	 * Imagine que você tem uma classe que vai implementar funcionalidades de uma api.
	 *  Porém, você não está interessado em pegar uma implementação específica,
	 *  mas sim qualquer implementação.
	 *  
	 * No contexto de módulo, essa situação é chamada de serviço.
	 *  
	 * Com o sistema de módulos você consegue depender apenas do módulo que define
	 *  as interfaces. Você consegue dizer que determinada interface vai ser provida
	 *  a partir de uma de suas implementações.
	 *  
	 * Por que isso é bom? Porque você pode mudar a implementação de tempos em tempos.
	 *  Se essa implementação mudar, você não vai ter que manualmente corrigir o código.
	 *  
	 * O próprio sistema de módulos vai dizer quais são as classes que vão prover uma
	 *  implementação para determinada interface.
	 *  
	 * Invés de você depender diretamente da classe concreta, você dependerá da interface e
	 *  via sistema de módulos são fornecidas suas implementações. Você seleciona uma das
	 *  implementações e executa essa classe concreta.
	 *  
	 * A ideia é você definir uma interface a partir de um módulo genérico da sua
	 *  api(somente com interfaces), e aí você tem outros módulos que vão prover
	 *  implementações para essas interfaces.
	 *  
	 *  
	 * Exemplo de utilização:
	 * 
	 * Módulo de app.calculo
	 *  
	 *  requires app.api; // Requerindo o módulo que contêm a interface.
	 *  provides br.com.cod3r.app.Calculadora 
	 *  with br.com.cod3r.app.calculo.CalculadoraImpl;
	 *  	// Declarando que o módulo atual "app.calculo" provê uma implementação
	 *  		 			de "Calculadora" na classe "CalculadoraImpl".
	 *  
	 *  
	 * Módulo de app.financeiro
	 * 
	 * //requires app.calculo; // Estava criando uma dependência direta da implementação.
	 * 
	 * 	requires app.api;
	 *  uses br.com.cod3r.app.Calculadora; 
	 *  	// Declarando que vou utilizar o serviço de Calculadora.
	 *  
	 *  
	 * Na classe que vai utilizar a implementação:
	 * 
	 * //CalculadoraImpl calc = new CalculadoraImpl();
	 * 					// Dependência direta com a implementação.
	 * //System.out.println(calc.soma(2, 3, 4));
	 * 
	 *  Calculadora calc = ServiceLoader
	 *  		.load(Calculadora.class) // Dizendo qual a interface que ele vai procurar.
	 *  		.findFirst() // Pegue o primeiro. O método retorna um optional de Calculadora.
	 *  		.get(); // Pegar a implementação.
	 *  System.out.println(calc.soma(2, 3, 4));
	 *  
	 *  
	 * Lembrando será sempre necessário atualizar o ModulePath para utilizar as implementações.
	 */
	
}