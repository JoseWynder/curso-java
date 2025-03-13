package swing.swingfinal;

import javax.swing.*;
import java.awt.*;

public class SwingDefinitivoJButton {
	
	/*
	 * O JButton da biblioteca Swing é um componente que cria um botão clicável,
	 *  permitindo que o usuário execute uma ação ao clicar nele.
     * 
     * Principais funcionalidades:
     * 
     * Criar um botão:
     * JButton button = new JButton("Texto do Botão");
     * 
     * Adicionar um ouvinte de ação:
     * button.addActionListener(e -> { ação a ser executada });
     * 
     * Definir ou obter texto:
     * button.setText("Novo texto"); e String text = button.getText();
     *
     * Quando usar:
     * 
     * Quando você precisa de um componente interativo que o usuário possa clicar para executar ações.
     * Ideal para submeter formulários, iniciar processos, navegar entre telas ou qualquer outra ação que necessite de uma interação do usuário.
	 */

    public static void main(String[] args) {
    	
        // Cria uma instância de JFrame
        JFrame frame = new JFrame("JButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new FlowLayout());

        // Cria um botão com texto
        JButton button = new JButton("Me Clique!");
        
        // define um comando de ação associado ao botão, que é útil para identificar
        //  qual botão foi acionado quando vários botões compartilham o mesmo ActionListener.
//        button.setActionCommand("myButton");
        /*
         * JButton button1 = new JButton("Button 1");
	     * button1.setActionCommand("button1Command");
	     * button1.addActionListener(myListener);
	     * 
	     * JButton button2 = new JButton("Button 2");
	     * button2.setActionCommand("button2Command");
	     * button2.addActionListener(myListener);
	     * 
	     * // ActionListener compartilhado
	     * ActionListener myListener = e -> {
         * 	String command = e.getActionCommand();
         * 		switch (command) {
         *     		case "button1Command":
         *         		System.out.println("Button 1 clicked");
         *         		break;
         *     		case "button2Command":
         *         		System.out.println("Button 2 clicked");
         *         		break;
         * 		}
	     * 	};
         */
        
        // Define uma dica que aparece quando o cursor passa sobre o botão
        button.setToolTipText("Clique para executar...");
        
//        // Define o ícone do botão (caso tenha uma imagem "icon.png" no diretório de recursos)
//        ImageIcon icon = new ImageIcon(SwingDefinitivoJButton.class.getResource("/icon.png"));
//        button.setIcon(icon);

        // Define o tamanho do botão
        button.setPreferredSize(new Dimension(100, 40));

        // Define a cor de fundo do botão
        button.setBackground(Color.CYAN);
        
        // Define a cor do texto do botão
        button.setForeground(Color.BLACK);
        
        // Define uma borda para o botão
        button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        
        // Define se o botão está habilitado ou não
        button.setEnabled(true);

        // Adiciona um ActionListener para responder a cliques no botão
        button.addActionListener(e -> {
        	System.out.println("Botão clicado!");
        	JOptionPane.showMessageDialog(frame, "Você clicou no botão!");
        });

        // Adiciona o botão ao JFrame
        frame.add(button);

        // Adicionando outro botão com propriedades adicionais
        JButton button2 = new JButton("Desabilitar!");
        button2.setPreferredSize(new Dimension(120, 40));
        button2.setBackground(Color.LIGHT_GRAY);
        
        button2.addActionListener(e -> {
        	// Desabilita o primeiro botão quando o segundo é clicado
        	button.setEnabled(false);
        	System.out.println("Botão 1 desabilitado!");
        });

        // Adiciona o segundo botão ao JFrame
        frame.add(button2);

        // Torna o JFrame visível
        frame.setVisible(true);
    }
}


