package jpafinal.testefinal.consulta;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.consulta.NotaFilme;

public class ObterMediaFilmes {

	public static void main(String[] args) {

		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		// Como estamos trabalhando com uma função agregadora que não retorna mais
		//  de 1 elemento, é interessante criar um método no DAO que retorna a
		//  somente o elemento e não uma lista.
		NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");

		System.out.println(nota.getMedia());

		dao.fechar();
	}
}
