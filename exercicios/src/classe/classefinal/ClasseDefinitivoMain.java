package classe.classefinal;

public class ClasseDefinitivoMain {
	public static void main(String[] args) {
		
		/*
		 * Como eu estou dentro de um mesmo pacote
		   (ClasseDefinitivo e ClasseDefinitivoMain estão dentro do Pacote "classe")
		   eu consigo utilizar a classe ClasseDefinitivo sem necessariamente precisar importa-la.
		    Juntamente com todos os arquivos que estão dentro de "Java.lang".
		 * Se eu fosse importar, teria que acrescentar "import classe.classefinal.ClasseDefinitivo;" depois de "package classe.classefinal;".
		 * 
		 */
		
		// CONSTRUTOR
		
		/*
		 * O Construtor é um método especial que a partir de uma classe criar Objetos.
		 * "new" é a palavra reservada responsável por chamar um construtor.
		 * A unica diferença anatômica para um método é a ausência do tipo de retorno!
		 * O nome da classe define o nome do Construtor.
		 * 
		 * Toda classe possui um Construtor padrão ( ClasseDefinitivo() ). 
		    A partir do momento em que você cria outro Construtor ( ClasseDefinitivo(int a) ), o padrão deixa de existir.
		 * 
		 * 
		 */
		
		ClasseDefinitivo p1 = new ClasseDefinitivo("Notebook", 4356.89); // Construtor // Primeira Instância.
		
		var p2 = new ClasseDefinitivo();	 // Construtor padrão // Segunda Instância.
		p2.nome = "Caneta Preta";
		p2.preco = 12.56;
		
		double precoFinalp1 = p1.precoComDesconto(); // Chamando o método.
		System.out.printf("Preço final de %s = %.2f\n", p1.nome, precoFinalp1);
		
		ClasseDefinitivo.desconto = 0.29; // Acessando um atributo pertencente a classe.
		
		double precoFinalp2 = p2.precoComDesconto(0.21);
		ClasseDefinitivo.imprimirString /*Acessando um método pertencente a classe.*/ 
				(String.format("Preço final de %s = %.2f", p2.nome, precoFinalp2));
		
		
		double mediaCarrinho = (precoFinalp1 + precoFinalp2) / 2;
		System.out.printf("Média do carrinho = %.2f\n", mediaCarrinho);
		System.out.printf("Desconto final = %s\n\n", p1.descontoFormatado());
		

		
		/*
		 * Qual a diferença de "algumaCoisa.preco" e "algumaCoisa.preco()"
		 * A diferença é que no primeiro exemplo eu estou chamando um Atributo(variável) e no segundo um Comportamento(método)
		 * O que diferencia os dois são os parênteses.
		 */
		
		
		// ATRIBUIÇÃO: VALOR VS REFERÊNCIA
		
		
		// A atribuição por valor acontece nos primitivos e a por referência nos objetos.
		
		
		// CASO 1:
		
		byte a = 2; 
		byte b = a; // Atribuição por valor (Tipo primitivo)
		a++;       
		b--;
		System.out.println
		("CASO 1: A = " + a + " e B = " + b); // Váriaveis apontando para endereços diferentes na memória.
		
		
		// CASO 2:
		
		ClasseDefinitivo c = new ClasseDefinitivo();
		c.preco = 2;
		ClasseDefinitivo d = c; // Atribuição por referência (objetos)
		c.preco++;
		d.preco--;
		System.out.println
		("CASO 2: c = " + c.preco + " e d = " + d.preco); // Váriaveis apontando para um mesmo endereço na memória.
		
		
		// CASO 3:
		
		d = new ClasseDefinitivo(); // D passa a apontar para um novo endereço na memória.
		d.preco = 5;
		System.out.println
		("CASO 3: c = " + c.preco + " e d = " + d.preco); // Váriaveis apontando para endereços diferentes na memória.
		
		
		// CASO 4:
		
		c = d; // Atribuição por referência. C passa a apontar para o mesmo endereço de memória que a variável D.
		c.preco++;
		d.preco--;
		System.out.println
		("CASO 4: c = " + c.preco + " e d = " + d.preco);
		
		System.out.println(); // Pular linha
		
		/*
		 * Neste momento, o objeto inicial em que a variável c apontava é perdido.
		 * Quando você tem um objeto que não é mais referênciado por nenhuma variável, esse objeto é excluído
		   automáticamente da memória atravéz do precesso de garbage collector(coletor de lixo do Java).
		 *
		 * Quando você faz uma atribuição entre objetos, necessariamente você utilizará da atribuição por referência.
		 * Você pode usar o método clone para criar uma cópia exata de um objeto sem precisar atribuir uma referência.
		 * 
		 * Se você passa um objeto como parâmetro para um método esse objeto também é passado como referência.
		 * 
		 */
		
		
		// Exemplo:
		
		ClasseDefinitivoMain.alterarObjeto(d); // Objeto
		System.out.println("(d.preco = 7) = " + d.preco);
		
		ClasseDefinitivoMain.alterarPrimitivo(a); // Primitivo
		System.out.println("(a = 7) = " + a);
		
		
	}
	
	static void alterarObjeto(ClasseDefinitivo d2) { d2.preco = 7; }
	static void alterarPrimitivo(byte a2) { a2 = 7; }
}
