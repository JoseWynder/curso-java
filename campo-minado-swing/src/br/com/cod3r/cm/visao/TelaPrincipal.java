package br.com.cod3r.cm.visao;

import javax.swing.JFrame;

import br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(5, 9, 10); // Valor original: (10, 18, 30)
		
		add(new PainelTabuleiro(tabuleiro));
		
		setTitle("Campo Minado");
		setSize(517, 328); // Valor original: (690, 438)
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // DISPOSE_ON_CLOSE
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
		
		// Precisaria de alguns ajustes para tonar o jogo funcional.
		// Como, por exemplo:
		// Fazer com que o primeiro click seja obrigatoriamente em um campo não minado.
		// Fazer com que o primeiro click seja obrigatoriamente no campo que abra a maior quantidade possível de outros campos.
		// Fazer com que não exitam situações em que é logicamente impossível acertar o campo. // Existem essas situações, ou seja, lógica do jogo mal otimizada.
		
		// Essas pequenas alterações, impossibilitaria que o jogador perca no primeiro click.
		// Também fazia com que não houvesse situações onde seu primeiro click seja em um campo isolado e cheio de bombas.
		
		
	}
}
