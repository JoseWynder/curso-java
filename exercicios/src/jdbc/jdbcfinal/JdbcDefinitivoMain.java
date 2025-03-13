package jdbc.jdbcfinal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JdbcDefinitivoMain {

	public static void main(String[] args) throws SQLException {
		
//		final String url = 
//			"jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSL=true";
		/* Essa String representa em que local vou estar acessando o meu banco de dados.
		 * jbdc : driverAcessado :// nomeServidor : porta / bancoDeDados
		 *  ? parâmetros & outroParâmetro.
		 * Nesse caso os parâmetros fazem com que ele não verfique o certificado do servidor.
		 *  mas vai utilizar uma conexão segura.
		 */
		
//		final String usuario = "root";
//		final String senha = "12345678";
		
		// Todas as interfaces utilizadas seram de java.sql
//		Connection conexao = DriverManager
//				.getConnection(url, usuario, senha);
		// DriverManager é responsável por criar uma conexão.
		// Esse método lança uma exception checada.
		
		/* Você pode passar de 3 formas diferentes os parâmetros para o método getConnection.
		 * 1- Somante a url, quando eu não tenho usuário e senha para acessar o banco de dados.
		 * 2- Um arquivo.properties.
		 * 3- url, usuario e senha.
		 */
		
		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o nome: ");
		String nome = entrada.nextLine();
		
		Connection conexao = JdbcDefinitivoMain.getConexao();
		
		String sql = """
				INSERT INTO pessoas (nome)
				VALUES (?)
				"""; // Text Blocks
		/* Quando falamos de inserir dados capturados do usuário no banco de dados temos
		 * que tomar cuidado com um ataque do tipo SQL Injection(SQLi).
		 * Não é interessante utilizar de concatenação.
		 * Para evitar um possível ataque utiliza-se a interface PreparedStatement.
		 */
		
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		
		// STATEMENT VS PREPAREDSTATEMENT
		
		/*
		 * A diferença vai além da simples adição de parâmetros.
		 * 
		 * A maioria dos bancos de dados relacionais lida com uma
		 *  consulta (query) JDBC / SQL em quatro passos:
		 * 
		 * Interpretar (parse) a consulta SQL;
		 * Compilar a consulta SQL;
		 * Planejar e otimizar o caminho de busca dos dados;
		 * Executar a consulta otimizada, buscando e retornando os dados.
		 * 
		 * Um Statement irá sempre passar pelos quatro passos acima para
		 *  cada consulta SQL enviada para o banco.
		 * 
		 * Já um Prepared Statement pré-executa os passos (1) a (3). 
		 *  Então, ao criar um Prepared Statement alguma pré-otimização é feita de imediato.
		 *  O efeito disso é que, se você pretende executar a mesma consulta
		 *  repetidas vezes mudando apenas os parâmetros de cada uma,
		 *  a execução usando Prepared Statements será mais rápida e com
		 *  menos carga sobre o banco.
		 * 
		 * Outra vantagem dos Prepared Statements é que, se utilizados corretamente,
		 *  ajudam a evitar ataques de Injeção de SQL. Note que para isso é preciso que
		 *  os parâmetros da consulta sejam atribuídos através dos métodos setInt(),
		 *  setString(), etc. presentes na interface PreparedStatement e não
		 *  por concatenação de strings.
		 * 
		 * Para uma consulta que não requer nenhum parâmetro e que vai ser executada poucas
		 *  vezes, um Statement basta. Para os demais casos, prefira PreparedStatement.
		 */
		
		stmt.execute();
			// Realiza a execução de um comando no banco de dados.
		
		System.out.println("Pessoa incluida com sucesso!");
		entrada.close();
		conexao.close(); // Fechando conexão.
		
		// Com exceção do DriverManager, a gente sempre vai trabalhar com interfaces.
		// Quem vai implementar essas interfaces vai ser o driver de conexão.
		
		/* mysql jdbc driver download. Platform Independert .zip
		 * Utilizar o arquivo de conexão .jar
		 * .jar é um Java ARchive. Ele é um arquivo/ficheiro compactado(.class)
		 *  usado para distribuir um conjunto de classes Java.
		 * Após colocar o arquivo em uma pasta dentro do projeto, cliquei com o botão direito
		 *  no arquivo e adicione um Build Path.
		 */
		
	}
	
	public static Connection getConexao() {
		try {
			Properties prop = getProperties();
				// Um arquivo.properties é basicamente uma chave e valor
				//  a partir de um arquivo textual.
			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String senha = prop.getProperty("banco.senha");
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	private static Properties getProperties() throws IOException {
			// Método responsável por consumir o arquivo.properties.
		Properties prop = new Properties();
//		String correntUserHomeDir = System.getProperty("user.home");
		// Caso a pasta esteja no diretório home do usuário.
		// O ideal seria ter o arquivo externo a pasta do projeto.
		String caminho = "/conexao.properties";
		prop.load(JdbcDefinitivoMain.class.getResourceAsStream(caminho));
			// Método que recebe uma inputStream.
			// O método também retorna uma exceção checada.
		return prop;
	}
}
