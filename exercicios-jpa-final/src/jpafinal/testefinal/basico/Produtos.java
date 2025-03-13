package jpafinal.testefinal.basico;

import java.util.List;

import jpafinal.infrafinal.DAO;
import jpafinal.infrafinal.ProdutoDAO;
import jpafinal.modelofinal.basico.Produto;

public class Produtos {

	public static void main(String[] args) {
		
		Produto produto = new Produto("Monitor 23", 789.98);
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.incluirAtomico(produto).fechar();
		System.out.println("ID do produto: " + produto.getId());
	
		
		List<Produto> produtos = new ProdutoDAO().obterTodos();
		for(Produto prod: produtos) {
			System.out.println("ID: " + prod.getId() + ", Nome: " + prod.getNome());
		}
		double precoTotal = produtos
				.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (t, p) -> t + p)
				.doubleValue();
		System.out.println("O valor total é R$" + precoTotal);
		
		
	}
}
