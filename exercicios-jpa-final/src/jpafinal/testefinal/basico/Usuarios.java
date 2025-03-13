package jpafinal.testefinal.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpafinal.modelofinal.basico.Usuario;

public class Usuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa-final");
		EntityManager em = emf.createEntityManager();
		
		
		
		// INSERIR USUÁRIO
		
		Usuario novoUsuario = new Usuario("Teste", "teste@lanche.com.br");
		
		em.getTransaction().begin();
			// Inicia a transação.
		em.persist(novoUsuario);
			// Método utilizado para inserir um determinado objeto no banco de dados.
			// O persist só vai realmente inserir um objeto no banco de dados se estiver
			//  em um contexto transacional.
			// Consulta não necessita estar em um contexto transacional.
		em.getTransaction().commit();
			// Efetiva a transação.
		
		System.out.println("O Id gerado foi: " + novoUsuario.getId());
		
		
		
		// REALIZANDO A CONSULTA DE 1 USUÁRIO
		
		Usuario usuario = em.find(Usuario.class, 7L);
		// Nesse exemplo o primeiro parâmetro é o tipo de classe e o segundo
		//  o identificador.
		System.out.println(usuario.getNome());
		
		
		
		// CONSULTAR TODOS OS USUÁRIOS
		
		// Não existe uma funcionalidade para obter todos os usuários
		//  nativamente no entity manager.
		String jpql = "select u from Usuario u";
			// Essa consulta sozinha é perigosa já que caso tenha
			//  1 milhão de linhas ele vai retornar 1 milhão de linhas.
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
			// TypedQuery = Consulta com título.
			// É passado a consulta e a classe que eu quero que retorne.
		
			/* Com o .class é passado como se fosse uma referência a classe.
			 * Com essa referência ela consegue fazer um processo chamado reflection,
			 *  ou seja, olhar dentro da classe e entender como ela foi construida.
			 * Basicamente o .class acaba sendo os metadados da classe.
			 */
		query.setMaxResults(5);
			// Limitando a quantidade de resultados retornados na consulta.
		
		List<Usuario> usuarios = query.getResultList();
			// É aqui que ele vai efetivar a consulta e armazenar o resultado.
		
		// Forma encadeada de realizar todos os passos anteriores.
//		List<Usuario> usuarios = em
//				.createQuery("select u from Usuario u", Usuario.class)
//				.setMaxResults(5)
//				.getResultList();
		
		for(Usuario user : usuarios) {
			System.out.println("ID: " + user.getId()
				+ " Email: " + user.getEmail());
		}
		
		
		
		// ALTERAR O USUÁRIO
		
		em.getTransaction().begin();
			// Atualização necessita de uma transação.
		
		usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Leonardo Leitão");
		usuario.setEmail("leonardo@lanche.com.br");
		
		em.merge(usuario);
			// merge() é responsável por pegar um usuário que já está no banco
			//  e realizar a alteração.
		
		em.getTransaction().commit();

		
		
		// ENTIDADE EM ESTADO GERENCIADO
		
		usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Leo");
			// Quando você realiza uma consulta dentro de um contexto transacional
			//  o resultado dessa consulta é dito como uma entidade que está
			//  em um estado gerenciado.
			// Estado gerenciado é quando o jpa tem um certo gerenciamento encima
			//  daquele objeto e qualquer mudança que você faça é sincronizada com o banco
			//  de dados mesmo que o método "merge" não seja chamado.
		
		em.getTransaction().begin();
			// Nessa situação, mesmo com o begin transaction após
			//  a alteração a mudança ainda é feita.
//		em.merge(usuario);
		em.getTransaction().commit();
		
		/* 
		 * O ideal é que você trabalhe majoritariamente com um objeto em estado não
		 * gerenciado para que ele não fiquei de tempos em tempos querendo sincronizar
		 * qualquer alteração. Somente quando for necessário persistir você entra
		 * em um contexto transacional e envia as informações para o banco de dados.
		 */

		
		
		// ENTIDADE EM ESTADO NÃO GERENCIADO
		
		em.getTransaction().begin();
		
		usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Leonardo");
		
		em.detach(usuario);
			// Desassocia a instância de um objeto.
			// Retira do estado gerenciado.
		
		em.merge(usuario);
			// Como o método "merge" a alteração é persistida.
			// Ele coloca o objeto em um estado gerenciado e faz a persistência.
		
		em.getTransaction().commit();
		
		/*
		 * Imagine a situação em que você está trabalhando com um sistema onde os dados
		 *  vieram do front-end, estão entrando na sua api feita em java e você cria
		 *  um objeto com esses dados do front. Ao criar um objeto do zero, esse
		 *  objeto está em um estado não gerenciado. Sendo assim, não é
		 *  qualquer mudança que é sincronizada no banco, mas, quando
		 *  você faz uma consulta para obter um objeto no banco de
		 *  dados, aí sim esse objeto dentro de um contexto
		 *  transacional estará em um estado sincronizado(gerenciado).
		 */
		
		
		
		// EXCLUIR USUÁRIO
		
		usuario = em.find(Usuario.class, 10L);
		
		if(usuario != null) {
			// Verifica se o usuário está nulo por que se o usuário vier nulo
			//  quer dizer que ele já não está na base.
			em.getTransaction().begin();
				// Sempre que eu fizer uma operação que gere impacto no banco de dados,
				//  eu preciso estar dentro de um contexto transacional.
			em.remove(usuario);
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
		
	}
}
