package swing.swingfinal;

import javax.swing.*;
import java.awt.*;

public class SwingDefinitivoJTextField {

	/*
	 * O JTextField da biblioteca Swing é um componente que permite ao usuário inserir uma única linha de texto editável.
	 *  Ele é utilizado quando se deseja obter entradas de texto do usuário, como nomes, endereços ou outros dados de entrada simples.
     *
	 * Principais funcionalidades:
	 * 
	 * Criar um campo de texto:
	 * JTextField textField = new JTextField(20); (onde 20 é o número de colunas de largura).
	 * 
	 * Obter texto inserido:
	 * String text = textField.getText();
	 * 
	 * Definir texto:
	 * textField.setText("Novo texto");
	 * 
	 * Quando usar:
	 * 
	 * Quando você precisa de uma entrada de texto de uma linha em sua interface gráfica.
	 * Ideal para formulários, diálogos de entrada de dados e outras situações onde o usuário precisa fornecer informações textuais.
	 */
	
    public static void main(String[] args) {
    	
        // Cria uma instância de JFrame.
        JFrame frame = new JFrame("JTextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new FlowLayout());

        // Cria um JTextField com um número inicial de colunas.
        JTextField text1 = new JTextField(20);
        // Define o texto inicial do JTextField.
        text1.setText("Com Texto");

        // Cria um JTextField com texto editável (padrão).
        JTextField text2 = new JTextField("Texto não editável");
        // Define o texto como não editável.
        text2.setEditable(false);

        // Define a cor de fundo.
        text1.setBackground(Color.CYAN);

        // Define a cor do texto.
        text1.setForeground(Color.RED);

        // Define a fonte e o tamanho do texto.
        text1.setFont(new Font("Arial", Font.BOLD, 14));

        // Cria um JButton para obter o texto.
        JButton getTextoButton = new JButton("Get Texto");
        getTextoButton.addActionListener(e -> {
        	// Obtém o texto do JTextField e exibe em uma caixa de diálogo.
        	String texto = text1.getText();
        	JOptionPane.showMessageDialog(frame, "Campo Texto 1: " + texto);
        });

        // Cria um JButton para definir o texto do JTextField.
        JButton setTextoButton = new JButton("Set Texto");
        setTextoButton.addActionListener(e -> text1.setText("Novo Texto Setado!"));
        // Define um novo texto para o JTextField
        

        // Adiciona os JTextFields e JButtons ao JFrame.
        frame.add(text1);
        frame.add(text2);
        frame.add(getTextoButton);
        frame.add(setTextoButton);

        // Torna o JFrame visível.
        frame.setVisible(true);
    }
}