package oo.oofinal;

public class Conceitos {

	// COMPOSIÇÃO
	
	/*
	 * Composição é quando você tem um objeto mais complexo e ao invés de você implementar tudo dentro do objeto,
	 *  você quebra em outros objetos menores.
	 */
	
	
	// RELAÇÕES - *Capítulo composicao*
	
	// ------------------------------------------------------------------------------------------
	
	// Relação 1 para 1.
	
	/*
	 * Carro ----- Motor
	 *  O carro tem 1 motor e o motor pertence a 1 carro.
	 */
	
	// ------------------------------------------------------------------------------------------
	
	// Relação 1 para n.
	
		/*
		 * Compra ----< Item
		 *  Uma compra tem 'n' itens e um item pertence a 1 compra.
		 */
	
	// ------------------------------------------------------------------------------------------
	
	// Quando pensamos em 'n' pensamos em Coleções (Array, Set, List, Map...)
	
	// ------------------------------------------------------------------------------------------
	
	// Relação n para n.
	
			/*
			 * Tio >---< Sobrinho
			 *  Um tio tem 'n' sobrinhos e um sobrinho tem 'n' tios.
			 */
	
	// ------------------------------------------------------------------------------------------
	
	// Essas são relações de composição, um objeto é composto por outros objetos em que as classes se relacionam.
	
	/* Uma aplicação em que todas as classes dependem de todo mundo não é um cenário recomendado(alto acoplamento).
	 * Quanto mais relacionamentos existirem entre as classes, mais complicado será para manter o sistema.
	 * Levando em consideração que qualquer alteração em uma das classes afetaria toda a cadeia.
	 */
	
	/* Neste contexto, quando falamos de relacionamento, temos relacionamentos unidireionais e bidirecionais.
	 * Unidirecional é quando, por exemplo, o carro depende do motor mas o motor não depende do carro.
	 * Bidirecional é quando eles dependem um do outro.
	 */ 
	
	
	
	
	
	// PARADIGMAS
	
	
	
	
	/*
	 * Os paradigmas são forma de estruturar ideias para que você possa pegar algo do mundo real e transformar em software.
	 * 
	 * 
	 *  NÃO ESTRUTURADO (GoTo)
	 * 
	 * 
	 * Antigamente tínhamos linguagens que usavam muito fortemente uma estratégia de programação não estruturada(baseada em GoTo).
	 * Que consistia basicamente em uma sequência de códigos que em algum momento há uma mudança de fluxo para outra parte dessa sequência.
	 * Executando esse código até ser interrompido por um GoTo e redirecionado até a sequência de código desejada.
	 * Formando assim uma espécie de programação "macarrônica". Nessa época não existia o que chamamos hoje de função ou procedimento.
	 * 
	 * 
	 *  PROCEDURAL
	 *  
	 *  
	 * Paradigma procedural é baseado em procedimentos. 
	 * É nesse momento em que surge a função. Além do aperfeiçoamento das estruturas de controle.
	 * Essa é uma forma de programar muito focada em funções e também em ter dados compartilhados(globais).
	 * Tendo uma função que recebe dados, faz alterações e depois os retorna.
	 * Você tem um programa como sendo funções e esses dados. (Enquanto na oo trabalhamos com classes e objetos)
	 * 
	 * 
	 *  FUNCIONAL
	 *  
	 *  
	 * É um paradigma que se dá muito bem com processamentos paralelos já que trabalha muito fortemente com dados imutáveis(constantes).
	 * São muitos conceitos que serão trabalhados mais para frente.
	 * 
	 * 
	 * ORIENTAÇÃO A OBJETOS
	 * 
	 * 
	 * A oo tem foco no dado. 
	 * O dado é que tem alguns comportamentos. Quando você acrescenta métodos dentro da classe e quando você instancia os objetos,
	 *  os métodos passam a ser chamados a partir daqueles objetos.
	 * 
	 * Procedural vs Orientação a Objetos
	 * 
	 * P - Ator principal é a função (a função é que exerce o papel central dentro do paradigma)
	 * 	Você cria funções que recebem parâmetros e retorna valores.
	 * 
	 * formatarData(nascimento);
	 * 
	 * OO - Ator principal é o Objeto (dentro do objetos você tem atributos e comportamentos)
	 *  A partir do objeto você acessa o método.
	 * 
	 * nascimento.formatarData();
	 * 
	 * ------------------------------------------------------------------------------------------
	 * 
	 * Em outras linguagens, por exemplo,
	 * 
	 * JS
	 * 
	 * Você não cria por padrão uma função dentro de classes(Embora você possa).
	 * Você cria funções soltas, fora da classe, definida diretamente dentro de um arquivo. (PHP da mesma forma.)
	 * 
	 * Em Java isso não é possível. Java é uma linguagem muito forte no conceito de orientação a objeto.
	 * Já que Java já nasceu orientada a objeto. 
	 * Diferente de outras linguagens que nasceram procedurais e depois de um tempo foram agregando os conceitos de oo.
	 * Cada linguagem tem seus próprios paradigmas.
	 * 
	 *  Por exemplo: Java Script
	 *  Você pode programar orientado a objeto.
	 *  Você pode programar procedural.
	 *  Você também pode usar princípios de programação funcional.
	 *  
	 * A maioria das linguagens são ditas multiparadigmas!
	 * 
	 */
	
	
	
	
	
	// VISÃO GERAL - PILARES DA ORIENTAÇÃO A OBJETO
	
	
	
	
		// ENCAPSULAMENTO
		
		
		/*
		 * Parte da complexidade do objeto precisa estar escondido do mundo exterior.
		 * 
		 * Exemplo:
		 * Objeto carro(mundo real)
		 * 
		 * Parte do carro você consegue interagir diretamente, como a direção, marcha e os pedais.
		 * Que é a interface de comunicação entre o ser humano e o carro.
		 * Mas você não precisa conhecer como funciona internamente o motor do carro.
		 * Você pode nunca ter visto um motor e você ainda assim será capaz de dirigir
		 *  porque você consegue lidar com a interface de comunicação.
		 * O que tem dentro do carro, os processos que acontecem de queima de combustível, rotações do motor, ...
		 * Nada disso você precisa conhecer. Porque essa complexidade está encapsulada dentro do carro.
		 * Você não precisa conhecer os detalhes internos de um objeto para interagir com ele.
		 */
		
		
		// HERANÇA
		
		
		/*
		 * É um princípio de reuso de código.
		 * Assim como a gente viu o reuso de código utilizando composição, a herança também é um tipo de reuso de código.
		 * 
		 * Na composição temos uma relação "tem um".
		 * 
		 * Um cliente tem umas compras - tem umas
		 * A compra tem uns itens - tem uns
		 * Um item tem um produto - tem um
		 * 
		 * Na herança temos uma relação " é um".
		 * 
		 * Civic é um carro - é um
		 * Gato é um mamífero - é um
		 * maça é uma fruta - é uma
		 * 
		 * Não é uma regra absoluta!
		 */
		
		
		// POLIMORFISMO
		
		
		/*
		 * É a capacidade que você tem em usar algum conceito mais genérico e dentro dele colocar coisas expecíficas.
		 * Exemplo:
		 * 
		 * Posso criar no meu sistema um atributo animal e associar a esse animal um cachorro.
		 * Ou associar a esse animal um gato.
		 * Já que animal é mais genérico e gato e cachorro são tipos de animais.
		 * Ou seja, para haver um polimorfismo(dependendo do tipo) precisa existir herança.
		 */
		
		
		// ABSTRAÇÃO
		
		
		/*
		 * Quando você vai desenvolver um sistema você observa o mundo real.
		 * Ao observar, você se depara com a complexidade do mundo real.
		 * E essa complexidade precisa ser abstraída para que o sistema corresponda a necessidade do negócio.
		 * Nem todas as características e comportamentos de um objeto no mundo real estarão presentes no seu software.
		 * Nem todos os objetos do mundo real estarão presentes no seu software.
		 */
		
		
		
		
	
		// PILARES ------------------------------------------------------------------------------------------------------------
		
		
		
	
		// ENCAPSULAMENTO
		
		
		/*
		 * Quando falamos de composição(um objeto dependendo outro) você se preocupa apenas com aquilo que está visível
		 *  e não com aquilo que está encapsulado.
		 * Então, selecionar alguns objetos e atributos para serem escondidos é muito importante.
		 * Um baixo nivel de encapsulamento pode gerar um alto acoplamento.
		 * Quanto mais encapsulado, menor a chance de ocorrer algum problema no relacionamento entre as classes.
		 * Um encapsulamento envolve a cápsula, quem é a cápsula? A cápsula é o objeto.
		 * O objeto é um agrupador que agrupa os membros do objeto(atributos e comportamentos).
		 * O fato de você agrupar atributos e comportamentos te dá uma maior chance de você conseguir encapsular as coisas.
		 * Se você coloca o método que vai alterar o dado bem próximo ao dado,
		 *  é possível que aquele dado não precise ficar visível para nenhuma outra classe do seu sistema.
		 *  
		 *  Modificadores de acesso:
		 *  
		 *  Public            -  Qualquer classe do seu sistema pode acessar!
		 *  Protected         -  É transmitido por herança para outro pacote!
		 *  Package(default)  -  Só é acessível por classes do mesmo pacote!
		 *  Private           -  Só pode ser acessado dentro da própria classe!
		 *  
		 *  Tudo o que o private tem, o package tem e acrescenta alguma coisa.
		 *  Tudo o que o package tem, o protected tem e acrescenta alguma coisa.
		 *  Tudo o que o protected tem, o public tem e acrescenta alguma coisa.
		 * 
		 */
		
		
		// HERANÇA
		
		
		/*
		 * Quando se fala de reuso de código, sempre é preferível utilizar composição.
		 * Composição sempre será mais flexível do que a herança.
		 * 
		 * Na composição: Dentro da classe carro eu vou ter uma referência para motor.
		 * De forma em que a partir do motor eu consiga acessar os seus atributos.
		 * E a partir do carro, uma vez em que você acelera, gerar impacto no motor.
		 * 
		 * Na herança: Você vai herdar algumas características e comportamentos predefinidos da classe pai.
		 * Imaginando um Cívic como sendo um carro. Então você vai criar uma classe mais genérica "carro".
		 * Você vai criar uma outra classe mais específica "cívic" e o cívic vai herdar comportamentos de carro.
		 * Exemplo:
		 * 
		 * 	Todo carro tem o método ligar;
		 * 	Todo carro tem o método desligar;
		 * 	Todo carro tem o método acelerar;
		 * 	Todo carro tem o método freiar;
		 * 	
		 * Esse tipo de comportamento você pode receber via herança e
		 *  sem que seja necessário implementar absolutamente nada.
		 * Dentro do cívic você recebe esses comportamentos.
		 * Em um hierarquia, quanto mais específico você vai ficando, mais comportamentos vão sendo agregandos.
		 * Já que você vai herdando de todos os pais.
		 * 
		 * Super classe (+genérica)
		 * 
		 * Sub classe (+específica)
		 * 
		 * Nem toda hierarquia gera herança!
		 * 
		 * Exemplo:
		 * Soldado, Cabo, Sargento, Tenente e Capitão.
		 * 
		 * Alguns padrões de projeto ajudam a substituir herança por composição.
		 * Porque composição acaba sendo mais flexível do que herança.
		 * 
		 * Existem linguagens que permitem herança multipla. Isso não acontece em java. Uma classe só herda de 1 classe.
		 * Em uma sub classe você também pode reescrever algum comportamento herdado da super classe(@Override).
		 * 
		 * Caso o comportamento seja private ele não é herdado por padrão.
		 * 
		 */
		
		
		// POLIMORFISMO
		
		
		/*
		 * Existem dois tipos de polimorfismo, o estático(sobrecarga) e o dinâmico.
		 * Sobrecarga é quando você tem métodos com o mesmo nome e com parâmetros(assinatura) diferentes.
		 * É um polimorfismo estático porque ele acontece estáticamente no seu código.
		 * 
		 * Exemplo: 
		 * 
		 * opa()
		 * 
		 * opa(...)
		 * 
		 * opa(..., ...)
		 * 
		 * Não acontece de forma dinâmica durante a execução do código!
		 * 
		 * Um pré-requisito para um polimorfismo dinâmico é a presença de herança.
		 * 
		 * Carro - super classe
		 * Civic - sub classe de Carro
		 * Ferrari - sub classe de Carro
		 * 
		 * Civic c = new Civic(); 
		 * 		// Criei uma váriavel do tipo "Civic" e instanciei um "Civic".
		 * 
		 * Carro c = new Civic(); 
		 * 		// Existe a possíbilidade de criar uma váriavel mais genérica e instânciar um "Civic".
		 * 
		 * O polimorfismo dinâmico existe nessa situação porque uma vez criada uma variavél do tipo "Carro" e instânciada
		 *  um "Civic", você pode usar essa mesma váriavel 'c' para instânciar uma "Ferrari".
		 *  
		 *  Você consegue usando a mesma váriavel mais genérica, atribuir objetos de multiplas formas(objetos polimorficos).
		 *  
		 *  Exemplo:
		 *  
		 *  void estacionar(Civic c) {...} // Posso passar uma ferrari para o método? NÃO
		 *  // Posso passar uma outra classe que herda de carro(diferente de civic)? TAMBÉM NÃO
		 *  // Porquê esse é um método específico. Vai receber específicamente civic ou qualquer outra classe que herde de civic.
		 *  
		 *  void estacionar(Carro c) {...} // Mas posso usar o polimorfismo para criar um parâmetro mais genérico.
		 *  // Dessa forma a variável c poderá assumir multiplas forma.
		 *  // É um polimorfismo dinâmico porque tudo isso acontecer de forma dinâmica na execução do seu código.
		 *  
		 */
		
		
		// ABSTRAÇÃO
		
		
		/*
		 * Abstração também pode ser entendida como uma simplificação.
		 * Simplificar algo do mundo real e colocar dentro do software.
		 * Muitas classes não tem um correpondente no mundo real.
		 * As vezes temos classes que representão apenas conceitos que são necessários dentro do software.
		 * Para a questão de organização, separação de interesses, ...
		 * Esse é um príncipio muito forte da oo, se espelhar no mundo real e mapear o mundo real em software.
		 * A partir dos mecanismos da orientação a objeto.
		 * 
		 */
	
		// ------------------------------------------------------------------------------------------------------------
	
		// CLASSE ABSTRATA
	
		/*
		 * Interface ---------------------------------------------- Classe concreta
		 * 
		 * Classe concreta é uma classe onde todos os métodos estão definidos. 100% de implementação
		 * 
		 * Interface é uma estrutura que tem métodos sem corpo(apenas sua definição). 0% de implementação
		 * Qual o tipo de retorno, nome e quais são os parâmetros que precisam ser passados.
		 * 
		 * Uma classe abstrata ela pode ou não ter todos seus métodos implementados. 0-100% de implementação
		 * Porém, uma classe abstrata não pode ser instânciada!
		 * É necessário declarar um método como "abstract" caso ele só venha a ser definido pelas sub classes concretas.
		 */
	
	
	
	
}
