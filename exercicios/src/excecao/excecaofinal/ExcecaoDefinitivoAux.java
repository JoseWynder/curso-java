package excecao.excecaofinal;

import excecao.Aluno;

public class ExcecaoDefinitivoAux { // Classe responsável por realizar validações.

private ExcecaoDefinitivoAux() {}
	
	public static void aluno(Aluno aluno) // Método para validar o aluno passado.
			throws ExcecaoDefinitivo, IllegalArgumentException {
		
		if(aluno == null) {
			throw new IllegalArgumentException("O aluno esta nulo!");
				// Exceção do próprio java.
		}
		if(aluno.nome == null || aluno.nome.trim().isEmpty()) {
			throw new ExcecaoDefinitivo("nome");
				// Exceção que foi criada.
		}
	}
	
}
