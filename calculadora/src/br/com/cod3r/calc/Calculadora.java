package br.com.cod3r.calc;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import br.com.cod3r.calc.visao.Display;
import br.com.cod3r.calc.visao.Teclado;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {

	public Calculadora() {
		
		organizarLayout();
		
		setSize(326, 452);
//		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	private void organizarLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(326, 84));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);
		
	}


	public static void main(String[] args) {
		new Calculadora();
	}
}
