package jdbc.jdbcfinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDefinitivoMainAux {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o codigo da pessoa: ");
		int codigo = entrada.nextInt();
		
		String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = JdbcDefinitivoMain.getConexao();
		PreparedStatement stmt1 = conexao.prepareStatement(selectSQL);
		stmt1.setInt(1, codigo);
		ResultSet result = stmt1.executeQuery();
			// executeQuery() retorna um ResultSet,
			//  possibilitando armazenar o valor em uma variável.
			// Existe uma série de execute diferentes que atendem a várias necessidades.
		
		if(result.next()) {
			JdbcDefinitivo p = new JdbcDefinitivo(result.getInt(1), result.getString(2));
			
			System.out.println("O nome atual é " + p.getNome());
			
			System.out.print("Informe o novo nome: ");
			entrada.nextLine();
			String novoNome = entrada.nextLine();
			
			PreparedStatement stmt2 = conexao.prepareStatement(updateSQL);
			stmt2.setString(1, novoNome);
			stmt2.setInt(2, codigo);
			stmt2.execute();
			stmt2.close();
			
			System.out.println("Nome atualizado com sucesso para \" " + novoNome + " \".");

		} else {
			System.out.println("Pessoa não encontrada!");
		}
		
		entrada.close();
		stmt1.close();
		conexao.close();
		
		System.out.println();
		
		// Testando a implementação do padrão DAO.
		
		JdbcDefinitivoMainAux dao = new JdbcDefinitivoMainAux();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		System.out.println(dao.incluir(sql, "João da Silva"));
		System.out.println(dao.incluir(sql, "Ana Júlia"));
		System.out.println(dao.incluir(sql, "Djalma Pereira"));
		
		dao.close();
	}
	
	// IMPLEMENTAÇÃO SIMPLES DO PADRAO DAO
	// Nesse caso não é uma implementação de alto nível do DAO
	//  já que você ainda precisará passar o SQL.
	
	private Connection conexao;
	
	public int incluir(String sql, Object... atributos) {
		// Varargs de Object.
		try {
			PreparedStatement stmt = getConexao().prepareStatement(
					sql, PreparedStatement.RETURN_GENERATED_KEYS);
				// O "RETURN_GENERATED_KEYS" retorna o valor das chaves criadas.
			AdicionarAtributos(stmt, atributos);
				// Adiciona a lista de atributos dentro do Statement.
			
			if(stmt.executeUpdate() != 0) {
				ResultSet resultado = stmt.getGeneratedKeys();
				
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			
			return -1;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void close() {
		// Responsável por encerrar a conexão.
		try {
			getConexao().close();
		} catch (SQLException e) {
		} finally {
			conexao = null;
		}
	}
	
	private void AdicionarAtributos(PreparedStatement stmt,
			Object[] atributos) throws SQLException {
			// Esse método espera que você passe os atributos na ordem correta.
		
		int indice = 1;
		for(Object atributo : atributos) {
			if(atributo instanceof String) {
				stmt.setString(indice, (String) atributo);
			} else if(atributo instanceof Integer) {
				stmt.setInt(indice, (Integer) atributo);
			}
			indice++;
		}
	}
	
	private Connection getConexao() {
		// Para facilitar a implementação foi utilizado os
		//  métodos de classe já existentes em JdbcDefinitivoMain.
		try {
			if(conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {
		}
		
		conexao = JdbcDefinitivoMain.getConexao();
		return conexao;
	}
}
