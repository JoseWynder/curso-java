package javafxfinal.componentes.paineis;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Caixa extends HBox {
	
	// Controla a cor.
	private static int i = 0;

	private String[] cores = { 
		"#c33c5e", "#39aac6", "#28d79a",
		"#fb750e", "#6657a8", "#f9060e"
	};

	public Caixa() {
		this(100, 100);
	}

	public Caixa(int largura, int altura) {
		setAlignment(Pos.CENTER);
		
		setMinWidth(largura); // Como o HBox tem o tamanho variável.
		setMinHeight(altura);
		
		BackgroundFill fill =  new BackgroundFill(
				Color.web(cores[i++]), CornerRadii.EMPTY, Insets.EMPTY);
		// Color.web() é o método que recebe uma string como parâmetro.
		setBackground(new Background(fill));
		
		if(i == 6) i = 0;
	}

	public Caixa comTexto(String texto) {
		Label label = new Label(texto);
		label.setFont(new Font(24));
		getChildren().add(label);
		return this;
	}
}
