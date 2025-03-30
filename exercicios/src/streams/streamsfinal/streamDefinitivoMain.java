package streams.streamsfinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class streamDefinitivoMain {

	public static void main(String[] args) {
		
		List<streamDefinitivo> aprovados = new ArrayList<>();
		aprovados.add(new streamDefinitivo("Lu", 7.1));
		aprovados.add(new streamDefinitivo("Ana", 6.5));
		aprovados.add(new streamDefinitivo("Luca", 4.9));
		aprovados.add(new streamDefinitivo("Gui", 9.4));
		
		System.out.println("Usando o foreach...");
		for (streamDefinitivo nota : aprovados) {
			System.out.println(nota.nome);
		}
		
		System.out.println("\nUsando Iterator...");
		Iterator<streamDefinitivo> iterator = aprovados.iterator();
//		iterator.forEachRemaining(aluno -> System.out.println(aluno.nome));
			// Percorre todo o Iterator executando um Consumer.
			// Após execução o "iterator" estará esgotado!
			// Sempre que o Iterator chega ao final da lista, você não consegue mais o consumir.
		
		while(iterator.hasNext()) { // hasNext() == tem próximo? -- boolean
			streamDefinitivo aluno = iterator.next(); // next() == próximo -- ++
			if(aluno.equals(new streamDefinitivo("Luca", 4.9))) {
				iterator.remove(); // remove() remove o ultimo elemento retornado pelo next().
					// Só pode ser chamado após o método next().
					// Não pode chamar mais de uma vez o remove() sem chamar antes um next().
					// Cuidado ao chamar um remove() se durante o Iterator você
					//  estiver alterando os elementos.
					// Cuidado ao usar o remove() em um contexto multithread.
			} else {
				System.out.println(aluno.nome);
			}
		}
		
		System.out.println("\nUsando Stream...");
		Stream<streamDefinitivo> stream = aprovados.stream();
		stream.forEach(aluno -> System.out.println(aluno.nome));
		
		
		
		// Dentro da API de Stream tem uma série de operadores.
		// +30 comportamentos disponíveis, uns 7 métodos static, ...
		
		// Dentre todos, existem 3 grandes:
		
		/* - BUILT Ops
		 * - INT. Ops
		 * - TERMINAL Ops
		 */
		
		/* As operações de built são as formas que você tem para criar uma stream.
		 * 
		 * A partir desse momento passamos a ter disponíveis as operações intermediárias.
		 * São essas operações que vão te ajudar a transformar os dados, passando por várias funções,
		 *  utilizando a ideia de compor uma função após a outra(pipeline de execução). 
		 * As operações intermediárias sempre retornam uma nova Stream.
		 * 
		 * Podemos ter streams ordenadas e não ordenadas.
         * Sequênciais ou não sequênciais. stream() ou parallelStream().
		 * 
		 * No geral:
		 * 
		 * Built -> Fonte de dados -- Stream de dados
		 * intermediate -> Stream de dados -- Stream de dados
		 * Terminal -> Stream de dados -- != Stream de dados
		 * 
		 * Operações terminais não permitem o encadeamento de operações intermediárias após ela.
		 * Elas encerram a stream.
		 * 
		 * Todas essas operações não alterar os dados originais.
		 */
		
		
		
		// CRIANDO STREAM
		
		
		Consumer<String> print = System.out::print;
		Consumer<Number> printf = x -> System.out.printf("%.5s", x);
		
		
		Stream<String> langs = Stream.of("\nJava ", "Lua ", "JS\n"); // Stream.of() é um dos Built.
		langs.forEach(print);
		
		String[] maisLangs = 
			{ "Python ", "Lisp "/*Linguagem funcional*/, "Perl "/*Linguagem de script*/, "Go\n" };
		
		Stream.of(maisLangs).forEach(print); // Criando uma Stream a partir do array.
		Arrays.stream(maisLangs).forEach(print); // Outra forma.
		Arrays.stream(maisLangs, 0, 4).forEach(print); 
			// Selecinando quais elementos adicionar através do index. Sempre: [ x, y [
		
		List<String> outrasLangs = Arrays.asList("C ", "PHP ", "Kotlin\n");
		outrasLangs.stream().forEach(print);
		outrasLangs.parallelStream().forEach(print);
		
//		Stream.generate(() -> "a").forEach(print); // Gera valores infinitos sem ordenação.
//		Stream.iterate(0, n -> n + 1).forEach(printf); // Gera valores infinitos com ordenação.
		
		
		
		// MAP
		
		
		// Trata a stream e retorna uma outra Stream de mesmo tamanho.
		
		System.out.println("\n");
		List<String> marcas = Arrays.asList("BMW ", "Audi ", "Honda ");
		marcas.stream()
			  .map(m -> m.toUpperCase())
			  .forEach(print); // forEach() é uma operação Terminal.

//		new streamDefinitivoAux();
		
//		UnaryOperator<String> maiuscula = n -> n.toUpperCase();
		UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";
//		UnaryOperator<String> grito = n -> n + "!!! ";
		
		System.out.println("\n\nUsando composição...");
		marcas.stream()
			.map(streamDefinitivoAux.maiuscula)
			.map(primeiraLetra)
			.map(streamDefinitivoAux::grito)
			.forEach(print);
		
		
		/* OBS: Dependendo da linguagem essas operações são tratadas de formas diferentes.
		 * Por exemplo, em JS, o Array é utilizado para fazer todas essas operações.
		 * O map está dentro do Array, o filter está dentro do Array, o reduce, ...
		 * Enquanto no Java isso é encontrado dentro do Stream.
		 */
		
		
		
		// FILTER
		
		
		/* Filtra a stream e retorna uma outra Stream de um tamanho menor ou igual.
		 * Utilizasse o Predicate para retornar ao filter já que o Predicate retorna boolean.
		 */
		
		System.out.println();
		
		List<streamDefinitivo> alunos = Arrays
				.asList(new streamDefinitivo("Ana", 7.8),
						new streamDefinitivo("Bia", 5.8),
						new streamDefinitivo("Gui", 6.8),
						new streamDefinitivo("Pedro", 8.8),
						new streamDefinitivo("Daniel", 9.8));
		
		Predicate<streamDefinitivo> aprovado = a -> a.nota >= 7;
		Function<streamDefinitivo, String> saudacaoAprovado = 
				a -> "\nParabens " + a.nome + "! você foi aprovado(a)!";
		
		alunos.stream()
		      .filter(aprovado)
		      .map(saudacaoAprovado)
		      .forEach(print);
		
		
		
		// REDUCE 01# // REDUCE 02#
		
		
		/* Transforma uma Stream de dados em praticamente qualquer outra coisa.
		 * Pelo reduce ser uma operação Terminal, ele não retorna uma Stream de dados.
		 */
		
		System.out.println("\n");
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		BinaryOperator<Integer> somar = (a, b) -> a + b;
	
		Integer total1 = nums.parallelStream().reduce(somar).get(); 
			// get() para capturar o resultado gerado, já que ele é um optional de Integer.
		System.out.println(total1);
	
		Integer total2 = nums.stream().reduce(100, somar); // Cuidado com o uso do parallelStream()
			// Por causa do valor inicial, o resultado será do mesmo tipo.
		System.out.println(total2);
		
		// Resultado foi um Opcional<Integer>...
		nums.stream()
		.filter(n -> n > 5)
		.reduce(somar)
		.ifPresent(printf);
		// .ifPresentOfElse(Consumer, Supplier) +ou- eu acho, algo assim.
		
		
		
		// REDUCE Cont...
		
		System.out.println("\n");
		
		streamMedia m1 = new streamMedia(); // Como o método adicionar() retornando void.
		m1.adicionarNota(8.3);
		m1.adicionarNota(6.7);
		System.out.println(m1.getMedia());
		
		streamMedia m2 = new streamMedia().adicionarNota(8.3).adicionarNota(6.7);
			// Como o método adicionar() retornando this.
		streamMedia m3 = new streamMedia().adicionarNota(7.9).adicionarNota(6.6);
			// return this == return this.adicionarNota(valor).
		
		System.out.println(m2.getMedia());
		System.out.println(m3.getMedia());
		
		System.out.println(streamMedia.combinar(m2, m3).getMedia());
		
		
		
		// REDUCE 03#
		
		System.out.printf("%n");
		
		// Reaproveitando a List "alunos" do FILTER.
		
		// Reaproveitando o Predicate "aprovado" do FILTER.
		Function<streamDefinitivo, Double> apenasNota = a -> a.nota;
		
		BiFunction<streamMedia, Double, streamMedia> calcularMedia = 
				(soma, nota) -> soma.adicionarNota(nota);
		BinaryOperator<streamMedia> combinarNotas = 
				(m4, m5) -> streamMedia.combinar(m4, m5);
		
		
		
		streamMedia somaNotas = alunos.stream()
			  .filter(aprovado)
			  .map(apenasNota)
			  .reduce(new streamMedia(), calcularMedia, combinarNotas);
					// (acumulador, valorAcumulado, combinador)
		
		System.out.println("A media da turma e " + somaNotas.getMedia());
		
		
		
		// MATCH
		
		System.out.println();
		
		// Reaproveitando a List "alunos" do FILTER.
		
		// Reaproveitando o Predicate "aprovado" do FILTER.
		Predicate<streamDefinitivo> reprovado = aprovado.negate();
		
		System.out.println(alunos.stream().allMatch(aprovado)); // Todos "aprovado"?
		System.out.println(alunos.stream().anyMatch(aprovado)); // Algum "aprovado"?
		System.out.println(alunos.stream().noneMatch(reprovado)); // Nenhum "reprovado"?
		
		
		
		
		// MIN e MAX
		
		System.out.println();
		
		// Reaproveitando a List "alunos" do FILTER.
		
//		Comparator<streamDefinitivo> melhorNota = new Comparator<streamDefinitivo>() {
//			@Override
//			public int compare(streamDefinitivo aluno1, streamDefinitivo aluno2) {
//				if(aluno1.nota > aluno2.nota) return 1;
//				if(aluno1.nota < aluno2.nota) return -1;
//				return 0;
//			}
//		}; // Sem lambda.
		
		
		Comparator<streamDefinitivo> melhorNota = (aluno1, aluno2) -> {
			if(aluno1.nota > aluno2.nota) return 1;
			if(aluno1.nota < aluno2.nota) return -1;
			return 0;
		};
		
		Comparator<streamDefinitivo> piorNota = (aluno1, aluno2) -> {
			if(aluno1.nota > aluno2.nota) return -1;
			if(aluno1.nota < aluno2.nota) return 1;
			return 0;
		};
		
		System.out.println(alunos.stream().max(melhorNota).get());
		System.out.println(alunos.stream().min(piorNota).get());
		
		System.out.println(alunos.stream().min(melhorNota).get());
		System.out.println(alunos.stream().max(piorNota).get());
		
		
		
		// OUTROS MÉTODOS
		
		System.out.println();
		
		List<streamDefinitivo> maisAlunos = Arrays
				.asList(new streamDefinitivo("Ana", 7.1),
						new streamDefinitivo("Luna", 6.1),
						new streamDefinitivo("Gui", 8.1),
						new streamDefinitivo("Gabi", 10),
						new streamDefinitivo("Ana", 7.1),
						new streamDefinitivo("Pedro", 6.1),
						new streamDefinitivo("Gui", 8.1),
						new streamDefinitivo("Maria", 10));
		
		System.out.println("distinct...");
		maisAlunos.stream().distinct().forEach(System.out::println);
			// distinct() não pega valor duplicado.
		
		System.out.println("\nSkip/Limit");
		maisAlunos.stream()
		.distinct()
		.skip(2) // Pegue a partir de dois
		.limit(2) // Pegue somente dois
		.forEach(System.out::println);
		
		System.out.println("\ntakeWhile");
		maisAlunos.stream()
		.distinct()
		.skip(2)
		.takeWhile(aprovado) 
			// Pegue elementos enquanto ocorrer uma determinada condição.
		.forEach(System.out::println);
		
	}
}
