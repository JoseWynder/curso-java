package br.com.cod3r.cm.modelo;

import static org.junit.jupiter.api.Assertions.*; 
	// Para utilizar os Assertions do JUnit 5!

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // @Test do JUnit 5.

import br.com.cod3r.cm.excecao.ExplosaoException;

public class CampoTeste {

	private Campo campo; // Definindo a classe utilizada para testar.
	
	@BeforeEach // Antes de cada.
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test // de "org.junit.jupiter.api.Test".
	void testeVizinhoEleMesmo() {
		Campo vizinho = new Campo(3, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado); // Assert do JUnit 5.
			// de "org.junit.jupiter.api.Assertions.assertFalse".
	}
	
	// Teste de cobertura diz a porcentagem de código que o teste percorreu.
	// Você pode executar um método específico selecionando o nome dele e executando.
	@Test
	void testeVizinhoLinhaDiferencaMaior() {
		Campo vizinho = new Campo(5, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeVizinhoLinhaDiferencaMenor() {
		Campo vizinho = new Campo(1, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeVizinhoLinhaDiferencaCorreta() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoColunaDiferencaMaior() {
		Campo vizinho = new Campo(3, 5);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeVizinhoColunaDiferencaMenor() {
		Campo vizinho = new Campo(3, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeVizinhoColunaDiferencaCorreta() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcado();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcado();
		campo.alternarMarcado();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcado();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcado();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
				// Espero que essa exceção seja lançada.
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos1() {

		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {

		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
}
