package jpafinal.testefinal.umparaum;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.umparaum.Assento;
import jpafinal.modelofinal.umparaum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {
		
		// Coloca em uso o relacionamento bidirecional gerado.
		
		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		
		Cliente cliente = daoCliente.obterPorID(1L);
		System.out.println(cliente.getAssento().getNome());
		
		daoCliente.fechar();
		
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		
		Assento assento = daoAssento.obterPorID(4L);
		System.out.println(assento.getCliente().getNome());
		
		daoAssento.fechar();
	}
}
