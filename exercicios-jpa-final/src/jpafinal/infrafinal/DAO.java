package jpafinal.infrafinal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E /* extends Entidade */ > {
	// Classe genérica.
	// Nesse contexto poderia ser criada um interface marcadora.
	// Uma interface marcadora não gera a obrigatoriedade da implementação de métodos.
	// É uma interface onde todas as classes que implementam ela representam entidades.
	// Dessa forma seria possível restringir o DAO através do generics.
	
	
	// Para realizar as operações de CRUD é necessário trabalhar com 2 objetos,
	//  o "EntityManager" e o "EntityManagerFactory".
		
	/* O Entity Manager é o gerente das entidades,
	 *  das classes mapeadas para tabelas no banco de dados.
	 * Dentro do entity manager também está embutido uma conexão. */
		
	/* O Entity Manager Factory é a fábrica do gerenciador de entidades.
	 * O papel do entity manager factory é criar um entity manager.
	 * Por que disso?
	 * O entity manager de certa forma tem encapsulado dentro dele uma conexão com
	 *  um banco de dados. E você pode precisar criar diferentes conexões basedas em
	 *  diferentes unidades de persistência. */
	

	private static EntityManagerFactory emf;
	// No caso de um atributo static o local de inicialização é ou na própria
	//  declaração ou através de um blobo estático.
	private EntityManager em;
	// Quando é criado um atributo de instância ele pode ser inicializado no construtor.
	private Class<E> classe;
	// É necessário receber a classe como parâmetro para poder realizar as consultas.
	
	static {
		// Esse bloco só é executado apenas uma vez no momento em
		//  que a classe for carregada pelo java.
		try {
			// Tem que ter cuidado por que se ocorrer um erro dentro do bloco estático
			// ele pode gerar um problema muito grande no carregamento da sua aplicação.
			emf = Persistence
					.createEntityManagerFactory("exercicios-jpa-final");
			// A "Persistence" é possivelmente a única classe do jpa.
			// Para o método "createEntityManagerFactory" é passado como parâmetro o nome
			//  da unidade de persistência, o banco de dados que você quer conectar.
			// Você está passando para a "Fábrica de conexões" onde estão as informações que
			//  ele vai precisar para abrir uma conexão com o banco de dados.
		} catch (Exception e) {
			// logar -> log4j
		}
	}
	
	public DAO() {
		this(null);
		// Em alguns momentos estaremos trabalhando com um DAO genérico.
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
		// Como esses métodos retornam o próprio objeto,
		//  é possível realizar um encadeamento.
	}
	
	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> remover(E entidade) {
		em.remove(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		// Método para incluir rapidamente quando não for necessário
		//  estar em um contexto transacional maior.
		// Algo atômico significa que o processo já vai realmente ser efetivado.
		// O conceito de transação é algo atômico. Se você colocar 10 comandos
		//  para serem executados no banco de dados, realizar isso de forma
		//  atômica significa que ou vai tudo ou não vai nada.
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	
	public List<E> obterTodos(int qtde, int deslocamento) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		// JPQL - A consulta é sempre sobre os objetos.
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	public List<E> consultar(String nomeConsulta, Object... params) {
		// params -> chave & valor.
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		int tamanhoArrayObject = params.length;
		for (int i = 0; i < tamanhoArrayObject; i += 2) {
			// Pegando o (nome, valor).
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params) {
		// Você consegue utilizar o mesmo método "createNamedQuery"
		//  independente se a classe é uma entidade ou não.
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void fechar() {
		em.close();
	}
	
}
