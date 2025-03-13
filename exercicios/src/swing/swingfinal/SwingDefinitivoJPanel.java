package swing.swingfinal;

import javax.swing.*;
import java.awt.*;

public class SwingDefinitivoJPanel {

	/*
	 * O JPanel da biblioteca Swing é um contêiner genérico para armazenar e organizar outros componentes da interface gráfica.
	 *  Ele é utilizado para agrupar componentes e organizar o layout da interface.
     * 
     * Principais funcionalidades:
     * 
     * Criar um painel:
     * JPanel panel = new JPanel();
     * 
     * Adicionar componentes:
     * panel.add(new JButton("Botão"));
     * 
     * Definir layout:
     * panel.setLayout(new BorderLayout());
     * 
     * Quando usar:
     * 
     * Quando você precisa agrupar componentes de interface em uma área específica.
     * Ideal para organizar a disposição dos componentes em layouts complexos, criar seções distintas na interface e
     *  alinhar diferentes layouts dentro de um contêiner principal.
	 */
	
	
    public static void main(String[] args) {
    	
        // Cria uma instância de JFrame.
        JFrame frame = new JFrame("JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new BorderLayout());

        // Cria um JPanel com um layout de BorderLayout.
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Define o layout do JPanel.

        // Define a cor de fundo do JPanel.
        panel.setBackground(Color.LIGHT_GRAY);

        // Cria um JButton e adiciona ao JPanel.
        JButton button1 = new JButton("Botão 1");
        panel.add(button1, BorderLayout.NORTH); // Adiciona o botão ao norte do JPanel.

        // Cria um outro JPanel para o centro
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout()); // Define o layout do JPanel interno.
        panelCentral.setSize(10, 10);
        
        panelCentral.setBackground(Color.MAGENTA);

        // Cria um botão e adiciona ao JPanel central.
        JButton button2 = new JButton("Botão 2");
        panelCentral.add(button2);

        // Adiciona o JPanel central ao JPanel principal.
        panel.add(panelCentral, BorderLayout.CENTER);

        // Cria um terceiro JPanel para o sul.
        JPanel panelSul = new JPanel();
        panelSul.setLayout(new GridLayout(1, 2)); // Layout de GridLayout para dois botões na horizontal.
        
        panelSul.setBackground(Color.PINK);

        // Adiciona dois botões ao JPanel do sul.
        JButton button3 = new JButton("Botão 3");
        JButton button4 = new JButton("Botão 4");
        panelSul.add(button3);
        panelSul.add(button4);

        // Adiciona o JPanel do sul ao JPanel principal.
        panel.add(panelSul, BorderLayout.SOUTH);

        // Adiciona o JPanel principal ao JFrame.
        frame.add(panel, BorderLayout.CENTER);

        // Adiciona um ActionListener ao primeiro botão.
        button1.addActionListener(e -> System.out.println("Botão 1 clicado!"));
        

        // Adiciona um ActionListener ao segundo botão.
        button2.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Botão 2 clicado!"));
        

        // Torna o JFrame visível
        frame.setVisible(true);
    }
}

