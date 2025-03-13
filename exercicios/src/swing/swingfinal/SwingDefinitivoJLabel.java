package swing.swingfinal;

import javax.swing.*;
import java.awt.*;

public class SwingDefinitivoJLabel {
	
	/*
	 * O JLabel da biblioteca Swing é um componente que exibe um rótulo de texto ou um ícone (imagem) não editável.
	 *  Ele é utilizado para mostrar informações ao usuário, como instruções, nomes de campos ou mensagens de status.
     *    
     * Principais funcionalidades:
     * 
     * Criar um rótulo:
     * JLabel label = new JLabel("Texto do rótulo");
     * 
     * Definir ou obter texto:
     * label.setText("Novo texto"); e String text = label.getText();
     * 
     * Definir um ícone:
     * label.setIcon(new ImageIcon("caminho/para/imagem.png"));
     * 
     * Quando usar:
     * 
     * Quando você precisa exibir texto ou ícones que não precisam ser editados pelo usuário.
     * Ideal para títulos, descrições, etiquetas de campos de entrada, mensagens de status e outros textos informativos na interface gráfica.
	 */

    public static void main(String[] args) {
    	
        // Cria uma instância de JFrame.
        JFrame frame = new JFrame("JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new FlowLayout());
        	// Atrapalha a definição da posição dos componentes.

        // Cria um JLabel com texto.
        JLabel label1 = new JLabel("Hello, JLabel!");
        
        // Define a cor do texto do JLabel.
        label1.setForeground(Color.BLUE);
        
        // Define o tamanho do texto.
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        
//        // Define um ícone para o JLabel (caso tenha uma imagem "icon.png" no diretório de recursos).
//        ImageIcon icon = new ImageIcon(SwingDefinitivoJLabel.class.getResource("/icon.png"));
//        label1.setIcon(icon);
        
        // Define o texto do JLabel que será exibido ao lado do ícone.
        label1.setText("Label Label Label?");

        // Define a posição do texto no JLabel.
//        label1.setHorizontalAlignment(SwingConstants.CENTER);
//        label1.setVerticalAlignment(SwingConstants.CENTER);
        	// Não funciona dependendo do layout definido para o JFrame.

        // Define a borda do JLabel.
        label1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Define a opacidade do fundo.
        label1.setOpaque(true);
        
        // Define a cor de fundo do JLabel.
        label1.setBackground(Color.LIGHT_GRAY);

        // Cria um segundo JLabel sem ícone.
        JLabel label2 = new JLabel("Texto Simples!");
        label2.setFont(new Font("Arial", Font.ITALIC, 14));

        // Adiciona os JLabels ao JFrame.
        frame.add(label1);
        frame.add(label2);

        // Cria um JButton para alterar o texto do JLabel.
        JButton mudarTextoButton = new JButton("Mudar Texto?");
        mudarTextoButton.addActionListener(e -> label1.setText("Texto Mudado!"));
       
        
        // Adiciona o botão ao JFrame.
        frame.add(mudarTextoButton);

        // Torna o JFrame visível.
        frame.setVisible(true);
    }
}