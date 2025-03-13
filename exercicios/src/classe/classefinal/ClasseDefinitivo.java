package classe.classefinal;

public class ClasseDefinitivo {

	 // Nome da classe pública precisa ser idêntico ao nome do arquivo.java
	
	
	// ANATOMIA DE UMA CLASSE ( ... Class Nome ...{ corpo } )
	
	
	// REVISÃO SOBRE CLASSE
	
	
	/*
	 * Nome -> Primeira letra de cada palavra em maiúsculo! (Convenção)
	 * Corpo -> Atributos e Comportamentos ( Características e Ações)
	 * 
	 * Atributos são DADOS (int, boolean, Date, String, Produto) [Estrutura de dados] (DADOS != ESTRUTURA DE DADOS)
	 * Comportamentos são MÉTODOS [Algoritmo]
	 * 
	 * Chamamos os Atributos e Comportamentos de dentro da classe, de Membros.
	 * A ideia da classe é ser um agrupador, dentro de uma única estrutura agrupar Atributos e Comportamentos. ( Derivado da Orientação a Objeto )
	 * 
	 * Uma classe define um tipo personalizado(ESTRUTURA DE DADOS)!
	 * A classe representa uma abstração do mundo real(simplificação)!
	 */ 
	 
	
	// CLASSE VS OBJETO
	
	
	/* 
	 * A classe define um tipo e os Objetos representam os DADOS.
	 * A classe dá a estrutura(ESTRUTURA DE DADOS), e o que você cria apartir da classe são os Objetos.
	 * 
	 * Objeto == Instância.
	 * Eu criei 10 Objetos do tipo Produto.
	 * O tipo é a classe e os Objetos são as instâncias que foram criadas.
	 * 
	 */
	
	
	// MEMBROS DE CLASSE
	
	
	/*
	 * Atributos e Comportamentos (DADOS E MÉTODOS)
	    Atributos -> Constantes e váriaveis.
	 * CONSTRUTORES
	 * MÉTODOS
	 * CLASSES
	 * 
	 * Dentro do corpo da classe ->
	 * 
	 * ________________________________________________________________________________________________
	 *                  ATRIBUTOS                  |                  COMPORTAMENTOS                   |
	 *---------------------------------------------|---------------------------------------------------|
	 *         VÁRIAVEIS    |      CONSTANTES      |         MÉTODOS         |      CONSTRUTORES       |
	 *    CLASSE     OBJETO |  CLASSE      OBJETO  |    CLASSE     OBJETO    |                         |
	 *                      |                      |                         |                         |
	 *                      |                      |                         |                         |
	 *                      |                      |                         |                         |
	 *                      |                      |                         |                         |
	 *______________________|______________________|_________________________|_________________________|
	 *                                             
	 * O que diferencia um atributo pertencer a classe ou Objeto é a palavra STATIC.                                           
	 * Quando você utiliza essa palavra(STATIC) antes de um atributo você está dizendo que esse atributo pertence a classe.
	 *                                          
	 * Objeto.membro
	 * Apartir de um Objeto você consegue acessar os membros dele(independente se é de um Atributo ou Método).  
	 * Do mesmo jeito com Classes.
	 * 
	 *                                           
	 *                                           
	 *                                           
	 */
	
	// Nome de método começa com a primeira palavra em letras minúscula e cada nova palavra com a primeira letra maiúscula! (Convenção)
	
	
	/* ANATOMIA DE UM MÉTODO ( tipoDeRetorno nomeMetodo(parâmetros){ corpo } )
	  
	  	Exemplo: int somar (int a, int b) {
	  		return a + b;
      	}
      	
    */
	
	
	// REVISÃO SOBRE MÉTODOS
	
	/* Método é um Comportamento, está relacionado com algoritmo, com ação.
	 * 
	 * tipoDeRetorno [ nomeMetodo(tipo nome,...) ] { algoritmo } 
	 * 
	 * O que está entre [colchetes] representa a identidade do método.
	 * Porquê? Dentro de uma classe você só pode ter 1 método com o mesmo nome e a mesma quantidade && tipo de parâmetros.
	 * Perceba que o tipo de retorno e o algoritmo não fazem parte da identidade, ou seja, mesmo com o tipo de retorno e o algotimo diferentes,
	    caso o nome do método e a quantidade && tipo de parâmetros sejam iguais, os métodos conflitam(ERRO).
	 */
	
	
	
	
	
	String nome;
	double preco;
	// Esses 2 Atributos(variáveis) pertencem ao Objeto.
	static double desconto = 0.25; // Atributo pertencente a classe (static).
	
	double precoComDesconto() {   // Método
		return preco * (1 - desconto);
	}
	
	double precoComDesconto(final double descontoDoGerente) {   // Método
		return preco * (1 - (desconto + descontoDoGerente));
	}
	
	String descontoFormatado() {  // Método
		return String.format("%.2f%%", desconto*100);
	}
	
	static void imprimirString (String str) {  // Método que não retorna nada = void.
		System.out.println(str);
	}
	
	// Sobre construtores em ClasseDefinitivoMain
	
	ClasseDefinitivo() { // Construtor padrão
	}
	
	ClasseDefinitivo(String nome, double preco) {  // Construtor
		this.nome = nome;
		this.preco = preco;
	}
	
	
	// MEMBROS DE CLASSE VS INSTÂNCIA
	
	
	/*
	 * Em um atributo de instância, a cada nova instância criada os valores estaram associados à instância.
	    Cada instância poderá ter o valor desse atribudo diferente entre si.
	 * Em um atribudo de classe, a cada nova instância criada os valores estaram associados à classe.
	    Cada instância tem o mesmo valor de atributo compartilhado entre si. Pode ser alterado, mas afetará todas as instâncias!
	 * Não seria só definir esse atributo como padrão? Não, dessa forma cada instância terá um atributo diferente,
	   mesmo seu valor sendo igual, cada uma ocupará um espaço a mais na memória!
	    Isso porque o atributo pertencente a instância, tem seu espaço determinado pela quantidade de instâncias.
	    Enquanto em um atributo pertencente a classe, independente a quantidade de instâncias criadas, todas compartilham apenas um unico atributo.
	 *
	 * Você só consegue acessar um membro de instância após criar uma instância.
	    Em outras palavras, você precisa instânciar um objeto para apartir desse objeto acessar a variável.
	    Exemplo:
	    	String nome = "José"; //criado em outra classe
	    	
	    	ClasseDefinitivo d1 = new ClasseDefinitivo();
	    	System.out.println(d1.nome);
	    	
	 * Para acessar um membro de classe, basta acessa-lo.
	   Exemplo:
	   		static String nome = "José"; //criado em outra classe
	   		
	   	    System.out.println(ClasseDefinitivo.nome); 
	  	    
	 * Assim como você pode criar atributos estáticos, você também pode criar métodos estáticos.
	 *
	 */
	
	
	// THIS E THIS()
	
	
	 /*
	  * Utilizasse this para referenciar o objeto atual.
	  * static acessa static, instância acessa instância.
	  * Por this ser uma instância, ele não pode ser utilizado em métodos estáticos(pertencente a classe).
	  * 
	  * Você pode usar o this() para apartir de um construtor chamar outro construtor.
	  * O que vai definir qual construtor você está chamando é a quantidade e a ordem dos parâmetros.
	  * Um construtor com o método this() não pode chamar outro construtor com o método this() em loop;
	  */
	
	// VARIÁVEIS LOCAIS
	
	/*
	 * Quando você define um atributo fora de um método(dentro da classe) ele pode ser um atributo de instância ou de classe.
	 * Quando você define dentro de um método, dizemos que ele é local. Só pode ser visível dentro do método e depois de ser declarado.
	 * Assim como os parâmetros do método ou do construtor estão disponíveis apenas dentro do corpo.
	 */
	
	// VALOR PADRÃO
	
	/*
	 * Variáveis locais não são inicializada por padrão!
	 * Constantes também não podem ser inicializadas por padrão!
	 * 
	 * Valor de cada atributo quando não se é atribuido valor:
	 * 
	 * byte, short, int, long -> 0
	 * float, double -> 0.0
	 * boolean -> false
	 * char -> '\u0000' (primeiro elemento da tabela unicode)
	 * String -> null
	 * Objetos -> null
	 * 
	 * null = não aponta para nenhum endereço de memória.
	 * 
	 */
	
	// VALOR NULL
	
	/*
	 * Você não pode acessar funcionalidades de atributos com valor nulo!(NullPointerException)
	 * Não é um erro de compilação, ou seja, só será visto ao executar o código.(RunTime)
	 * Esse erro acontece ao acessar uma variável sem ela estar "setada". Sem apontar para nenhum endereço de memória.
	 * A forma mais básica para corrigir esse erro seria utilizar uma condicional(if != null).
	 */
	
	
	
	
}
