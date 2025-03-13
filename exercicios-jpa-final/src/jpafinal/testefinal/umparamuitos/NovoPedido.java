package jpafinal.testefinal.umparamuitos;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.basico.Produto;
import jpafinal.modelofinal.umparamuitos.ItemPedido;
import jpafinal.modelofinal.umparamuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Geladeira", 2789.99);
		ItemPedido item = new ItemPedido(pedido, produto, 10);
		
		dao.abrirT()
			.incluir(produto)
			.incluir(pedido)
			.incluir(item)
			.fecharT()
			.fechar();
	}
}
