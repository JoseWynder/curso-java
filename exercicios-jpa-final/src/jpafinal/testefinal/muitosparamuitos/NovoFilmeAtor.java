package jpafinal.testefinal.muitosparamuitos;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.muitosparamuitos.Ator;
import jpafinal.modelofinal.muitosparamuitos.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		
		Filme filmeA = new Filme("Star Wars Ep 4", 8.9);
		Filme filmeB = new Filme("O Fugitivo", 8.1);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atrizB = new Ator("Carrie Fisher");
		
		// Operações em cascata.
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atrizB);
		
		filmeB.adicionarAtor(atorA);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomico(filmeA);
	}
}
