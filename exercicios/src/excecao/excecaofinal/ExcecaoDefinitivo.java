package excecao.excecaofinal;

@SuppressWarnings("serial")
	// MUITO CONFUSO, DEPOIS VEJO.

public class ExcecaoDefinitivo  extends Exception {

	
	// TIPOS DE ERROS
	
	
	// Erros de Comp.
	
	/* Os erros de compilação impedem o processo natural de você ter um arquivo.java 
	 *  com código fonte e gerar o seu arquivo.class.
	 * Ou seja, o compilador não vai executar esse processo quando você tem
	 *  um erro de compilação.
	 *  
	 * Erros de compilação não geram tantos problemas, já que o próprio compilador
	 *  interrompe a execução.
	 * Esse tipo de erro ocorre porque o java compila o seu código para uma linguagem
	 *  intermediária que é interpretada pela máquina virtual.
	 * É exatamente o processo de sair de um arquivo.java para um arquivo.class.
	 * 
	 * Linguagens que são interpretadas(como PHP, JS e Ruby), o interpretador lê diretamente
	 *  o código que você escreveu.
	 * Por isso você não tem esse conceito de erro de compilação,
	 *  já que o processo de compilação não ocorre.
	 * Até existe, por exemplo, no PHP, formas de compilar para ter uma otimização maior.
	 *  Mas, são coisas muito específicas.
	 * Essas linguagens interpretadas não tem, em essência, erros de compilação.
	 * 
	 */
	
	
	// Erros em tempo de Exec.
	
	/*
	 * Erros em tempo de execução são erros que ocorrem quando o programa já foi compilado.
	 *  Quando o usuário está acessando o programa.
	 * 
	 * Quando se fala em erros em tempo de execução temos,
	 *  basicamente, uma hierarquia de classe baseada em herança.
	 *  
	 * A "mãe" de todos os problemas que podem ocorrer em java é a classe Throwable.
	 * Ou seja, algo "lançavel".
	 * 
	 * Diferente de outros mecânismos em java, um erro(exceção), ele é lançado.
	 * A sua aplicação interrompe no momento em que aconteceu um erro e lança o erro.
	 * Quando esse erro é lançado, o processo é interrompido e quem chamou aquela
	 *  funcionalidade, aquele método, será responsável por tratá-lo.
	 *  
	 * Temos 2 grandes estruturas que herdam de Throwable:
	 * Error e Exception.
	 * 
	 * Error é algo mais sério, mais crítico.
	 * O Error normalmente é lançado em algo que não pode ser recuperado.
	 * Um exemplo seria o OutOfMemoryError.
	 * Um Error que ocorre por falta de memória.
	 *  Quando você está usando mais memória do que sua aplicação pode prover.
	 * Esse é um tipo de erro tão crítico que pela falta de memória,
	 *  a sua aplicação "morre" e para ali.
	 * Ou seja, esse é um tipo de cenário que você não vai se preocupar tanto em tratar
	 *  porque são erros mais críticos. São erros que vão realmente parar a sua aplicação.
	 *  
	 * Exception é o que seria uma exceção a regra.
	 * 
	 * É um tipo de erro em que é possível você se recuperar. Você pode tratar o erro.
	 * 
	 * Para o java uma Exception não é visto como algo ruim,
	 *  você inclusive pode gerar uma Exception.
	 *  Uma excesão é vista como um desvio do fluxo padrão.
	 * 
	 */
	
	
	// PILHA DE EXECUÇÃO
	
	
	/*
	 * O java é uma linguagem centrada em classes. A partir dessas
	 *  classes você vai ter métodos. Em que uma classe usa outra classe que usa outra...
	 * E assim você vai criando uma aplicação mais complexa.
	 *  Classes dependendo de outras e tendo como ponto de entrada o método main.
	 * Quando falamos de exceção acontece o que chamamos de Stack Trace.
	 * 
	 * 
	 * O conceito de pilha de execução segue a mesma lógica de uma pilha de livros em uma caixa.
	 * Imagine essa sequência de execução: 
	 * 
	 *  Main chama o método 1
	 *  O método 1 chama o 2
	 *  O método 2 chama o ...
	 *  Até o método 5.
	 *  
	 * Quando o seu programa começa a executar o método main, significa que o método main será
	 *  adicionado na pilha de execução(dentro da caixa), sendo o primeiro método a ser executado.
	 * Quando o método main chama o método 1, o método 1 é
	 *  adicionado na pilha(dentro da caixa, encima do main). Quando o método 1 chamar o método 2, 
	 *  o método 2 é adicionado na pilha(encima do método 1). E assim por diante.
	 *  
	 * Quando essa sequência de execução chegar no ultimo método(5), ao terminar de executá-lo,
	 *  O método 5 vai voltar para quem chamou ele(sendo retirado da caixa), o seu resultado
	 *   será retornado para o método 4, quando o método 4 terminar de ser executado, 
	 *    ele retornará o resultado para o método 3 e será retirado da pilha, ...
	 *    
	 * Até retornar para o método main e finalizar a execução.
	 *  Encerrando o programa e terminando com a pilha vazia.
	 * 
	 * 
	 * Nesse processo de execução, ao ocorrer uma exceção, quando o erro é mostrado no console,
	 *  você vai ver várias informações referentes a essa pilha de execução.
	 */
	
	
	private String nomeDoAtributo;
	
	
	public ExcecaoDefinitivo(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}
	
	@Override
	public String getMessage() { // Sobrescrevendo o método getMessage().
		return String.format("O atributo '%s' esta vazio.",
				nomeDoAtributo);
	}
	
	
}
