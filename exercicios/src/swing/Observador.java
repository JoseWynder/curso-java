package swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Observador {

	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Observador");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(300, 150);
		janela.setLayout(new FlowLayout());
		janela.setLocationRelativeTo(null); // Centralizar na tela!
		
		JButton botao = new JButton("Clicar!");
		janela.add(botao);
		
		botao.addActionListener(e -> System.out.println("Evento ocorreu!!!"));
		
//		janela.addFocusListener(new FocusListener() {
//			
//			@Override
//			public void focusLost(FocusEvent e) {
//				
//			}
//			
//			@Override
//			public void focusGained(FocusEvent e) {
//				
//			}
//		});
		
		janela.setVisible(true);
	}
}
