package jdbc;

public class DAOTeste {

	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		String sql = "INSERT IGNORE INTO pessoas (nome, codigo) VALUES (?, ?)";
		System.out.println(dao.incluir(sql, "João da Silva", 1006));
		System.out.println(dao.incluir(sql, "Ana Júlia", 1001));
		System.out.println(dao.incluir(sql, "Djalma Pereira", 1002));
		
		dao.close();
	}
}
