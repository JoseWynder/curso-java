package jpafinal.modelofinal.composicao;

import javax.persistence.Embeddable;

@Embeddable
// Com essa annotation o jpa vai pegar os atributos dentro de "Endereco"
//  e jogar dentro das tabelas "Fornecedor" e "Funcionario".
public class Endereco {

	private String logradouro;
	private String complemento;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
