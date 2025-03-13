package oo.composicao.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	final String nome;
	final List<Curso> cursos = new ArrayList<>(); 
		// Quando você diz que uma lista é "final" o que não pode mudar é o endereço de memória associado a lista.
		// "cursos" é constante mas seus elementos não.
	
	Aluno(String nome){
		this.nome = nome;
	}
	
	
	void adicionarCurso(Curso curso){
		this.cursos.add(curso);
		curso.alunos.add(this); // Para gerar uma relação bidirecional
	}
	
	Curso obterCursoPorNome(String nome) {
		for(Curso curso: this.cursos) {
			if(curso.nome.equalsIgnoreCase(nome)) {
				return curso;
			}
		}
		
		return null;
	}
	
	public String toString() {
		return nome;
	}
}
