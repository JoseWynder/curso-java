package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o codigo da pessoa: ");
		int codigo = entrada.nextInt();
		
		String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		// Consulta utilizando like.
		
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt1 = conexao.prepareStatement(selectSQL);
		stmt1.setInt(1, codigo);
		ResultSet r = stmt1.executeQuery();
			// executeQuery() retorna um ResultSet,
			//  possibilitanto armazenar o valor em uma variável.
		
		if(r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
			
			System.out.println("O nome atual é " + p.getNome());
			
			System.out.print("Informe o novo nome: ");
			entrada.nextLine();
			String novoNome = entrada.nextLine();
			
			PreparedStatement stmt2 = conexao.prepareStatement(updateSQL);
			stmt2.setString(1, novoNome);
			stmt2.setInt(2, codigo);
			stmt2.execute();
			stmt2.close();
			
			System.out.println("Nome atualizado com sucesso para \" " + novoNome + " \". ");

		} else {
			System.out.println("Pessoa não encontrada!");
		}
		
		entrada.close();
		stmt1.close();
		conexao.close();
	}
}
