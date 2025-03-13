package jpafinal.infrafinal;

import jpafinal.modelofinal.basico.Produto;

public class ProdutoDAO extends DAO<Produto> {
		// Resolvendo o generics.
	
	// Aqui dentro você pode criar métodos e funcionalidades específicas de produto.
	// Ex: Aplicar um desconto para todos os produtos da base.
	// Você pode criar um método específico para fazer isso sem necessariamente
	//  precisar colocar a complexidade desse método dentro do negócio.
	
	public ProdutoDAO() {
		super(Produto.class);
		
	}
}
