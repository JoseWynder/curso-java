package jpafinal.testefinal.umparamuitos;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.umparamuitos.ItemPedido;
import jpafinal.modelofinal.umparamuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorID(1L);
//		dao.fechar();
		
		for(ItemPedido item: pedido.getItens()) {
			// Essa consulta dos itens do pedido só é possível por que
			//  o Entity Manager ainda está aberto.
			// Se o atributo itens fosse "EAGER" seria possível realizar
			//  a consulta após fechar o Entity Manager.
			System.out.println(item.getQuantidade());
			System.out.println(item.getProduto().getNome());
		}
		
		dao.fechar();
	
	
	}
}
