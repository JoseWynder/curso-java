package jpafinal.testefinal.umparaum;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.umparaum.Assento;
import jpafinal.modelofinal.umparaum.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("16A");
		Cliente cliente = new Cliente("Carlos", assento);
		
		DAO<Object> dao = new DAO<>();
			// DAO de Object para não precisar criar 1 para cada objeto.
		
		dao.abrirT()
			.incluir(assento)
			.incluir(cliente)
			.fecharT()
			.fechar();
		// Como está em uma mesma transação, a ordem de inclusão não resultaria
		//  em nenhum erro. Porém, como o assento está mapeado dentro de cliente,
		//  primeiro é necessário ser incluído o assento.
	}
}
