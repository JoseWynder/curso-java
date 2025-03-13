package jpafinal.testefinal.umparaum;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.umparaum.Assento;
import jpafinal.modelofinal.umparaum.Cliente;

public class NovoClienteAssento2 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("4D");
		Cliente cliente = new Cliente("Maria", assento);
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.incluirAtomico(cliente);
		// Se não estiver setado o "cascade" na annotation @OneToOne de cliente,
		//  essa inclusão dará erro já que cliente possui um objeto que ele
		//  referencia que está em um estado não salvo, um estado transiente.
		
		
//		Cliente cliente = dao.obterPorID(12L);
//		dao.abrirT()
//		.remover(cliente)
//		.fecharT()
//		.fechar();
	}
}
