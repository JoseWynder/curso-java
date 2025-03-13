package swing.swingfinal;

import javax.swing.*;
import java.awt.*;

public class SwingDefinitivoJFrame {

	/*
	 * O JFrame da biblioteca Swing é uma janela principal da aplicação GUI que pode conter outros componentes e oferece uma área
	 *  de exibição com título, bordas e botões padrão de janela (minimizar, maximizar, fechar).
     * 
     * Principais funcionalidades:
     * 
     * Criar uma janela:
     * JFrame frame = new JFrame("Título da Janela");
     * 
     * Definir o tamanho:
     * frame.setSize(400, 300);
     * 
     * Adicionar componentes:
     * frame.add(new JButton("Botão"));
     * 
     * Definir a operação de fechamento:
     * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * 
     * Tornar a janela visível:
     * frame.setVisible(true);
     * 
     * Quando usar:
     * 
     * Quando você precisa de uma janela principal para a aplicação, onde todos os outros componentes serão adicionados.
     * Ideal para criar a estrutura básica de uma aplicação GUI, incluindo menus, barras de ferramentas, e áreas de conteúdo.
	 */
	
	public static void main(String[] args) {
		
		JFrame frame;
		
//		frame = new JFrame();
			// Cria uma instância de JFrame.
		
		frame = new JFrame("JFrame");
			// Cria uma instância de JFrame com o título especificado.
		
//        frame = new JFrame(GraphicsConfiguration gc);
        // Cria um JFrame usando a configuração gráfica específica.
		
		frame.setSize(400, 200);
			// Define o tamanho do JFrame.
		
//		frame.setSize(Dimension d);
			// Define o tamanho do JFrame utilizando um objeto quem contém a altura e largura.
		
//		 frame.setLocation(1200, 350);
		// Define a posição da janela na tela.
		frame.setLocationRelativeTo(null); 
		// Centralizar na tela!
		
//		 frame.setIconImage(iconImage);
		// Define um ícone para a janela.
		
//		 frame.setContentPane(contentPane);
		// Define um painel de conteúdo para o JFrame.
		
//		 frame.setTitle("setTitle");
		// Define um título para a janela.
		
		System.out.println(frame.getWidth());
		// Obter a largura.
		System.out.println(frame.getHeight());
		// Obter a altura.
		
		frame.getContentPane().setBackground(Color.YELLOW);
		// Define a cor de fundo da janela.
		
//		 frame.setAlwaysOnTop(true);
		// Define se a janela deve ser sempre exibida no topo.
		
		frame.setResizable(false);
		// Define se a janela pode ser redimensionada pelo usuário.
		
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Recebe um inteiro de 0 a 3.
		 /*
		  * Define a operação que acontecerá por padrão quando o usuário iniciar um "fechamento" neste quadro.

		• DO_NOTHING_ON_CLOSE(definido em WindowConstants):Não faça nada; exigem que o programa lide com a
		   operação no método windowClosing de um objeto WindowListener registrado. 
		• HIDE_ON_CLOSE (definido em WindowConstants): oculta automaticamente o quadro após invocar quaisquer
		   objetos WindowListener registrados. 
		• DISPOSE_ON_CLOSE (definido em WindowConstants): oculta e descarta automaticamente o quadro após
		   invocar qualquer objeto WindowListener registrado. 
		• EXIT_ON_CLOSE(definido em WindowConstants):Saia da aplicação usando o método de saída do sistema.
		   Use isso apenas em aplicativos. 

		  * O valor é definido como HIDE_ON_CLOSE por padrão. Alterações no valor desta propriedade provocam
		  *  o disparo de um evento propertychange, com nome de propriedade "defaultCloseOperation".
		  */
		 
//		 frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 // Define a janela maximizada no início.
		 frame.setExtendedState(JFrame.NORMAL);
		 
		 frame.setLayout(null);
		 // Define o layout do JFrame
		 // Antes de adicionar componentes, é uma boa prática definir o gerenciador de layout do JFrame
		 //  para organizar os componentes. Por padrão, o layout é BorderLayout, mas você pode definir
		 //  outros layouts, como FlowLayout, GridLayout, ou BoxLayout.
		 
//	     frame.setLayout(new BorderLayout());
//	     frame.add(new JButton("NO"), BorderLayout.CENTER);
		 	// Organiza os componentes em cinco regiões: NORTH, SOUTH, EAST, WEST, CENTER.
	     
	     frame.setLayout(new FlowLayout());
	     	// Organiza os componentes em uma linha, quebrando a linha conforme necessário.
	     
//	     frame.setLayout(new GridLayout());
	     	// Organiza os componentes em uma grade de células iguais.
	     
//	     frame.setLayout(new GridBagLayout());
	     	/*
	     	 * Divide o contêiner em uma grade com células de tamanhos variáveis.
			 * Permite especificar o alinhamento, o espaçamento e a expansão dos componentes dentro das células.
			 * Requer uso de GridBagConstraints para definir regras de layout para cada componente.
			 * 
			 * GridBagConstraints gbc = new GridBagConstraints();
             *
			 * gbc.gridx = 0;
		     * gbc.gridy = 0;
	         * panel.add(new JButton("Button 1"), gbc);
	     	 */
	     
		 JPanel panel = new JPanel();
//	     panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	     	// Organiza os componentes em uma única linha ou coluna.
	     	// É necessário passar um contêiner(JPanel) e definir sua posição.
	     
		 JButton botao = new JButton("JB. Panel");
		 // Cria um botão
		 
		 // frame.add(component);
		 // É usado para adicionar componentes à área de conteúdo de um JFrame.
		 //  Esses componentes podem ser qualquer coisa que estenda java.awt.Component,
		 //  como JButton, JLabel, JPanel, entre outros.
		 	
		 JPopupMenu menu = new JPopupMenu();
		 JMenuItem item = new JMenuItem("JMenu");
		 menu.add(item);
		 frame.add(menu);
		 
//		 System.out.println(frame.get...());
		 	// Muitos gets.
		 
		 JTextField textField = new JTextField(20);
		 
		 panel.add(botao);
		 // Adiciona o botão ao JPanel.
		 frame.add(panel);
		 // Adiciona o painel ao JFrame.
		 panel.add(textField);
		 frame.add(new JButton("JB. Frame"));
		 
		 frame.setVisible(true);
		 // Torna o JFrame visível ou invisível.
	}
}

