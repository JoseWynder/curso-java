package jpafinal.testefinal.consulta;

import java.util.List;

import jpafinal.infrafinal.DAO;
import jpafinal.modelofinal.muitosparamuitos.Ator;
import jpafinal.modelofinal.muitosparamuitos.Filme;


public class ObterFilmes {

	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.5);
		
		System.out.println(filmes.size());
		for(Filme filme: filmes) {
			System.out.println(filme.getNome() + " => " + filme.getNota());
			
			for(Ator ator: filme.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
	}
}
