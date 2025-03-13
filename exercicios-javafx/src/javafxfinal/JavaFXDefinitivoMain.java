package javafxfinal;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXDefinitivoMain extends Application {
	
	// O nome dos parâmetros dos métodos de JavaFX e algumas outras informações só são
	//  visíveis por que o código-fonte foi importado.
	
private int contador = 0;
	
	public void atualizarLabelNumero(Label label) {
		label.setText(Integer.toString(contador));
		
		// Só funciona se a lógica estiver distribuída dessa forma.
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		
		 if(contador > 0) {
			label.getStyleClass().add("verde");
		} else if(contador < 0) {
			label.getStyleClass().add("vermelho");
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// O JavaFX se baseia bastante no conceito de stage(palco) e scene(cena).
		// Imagine um teatro, um teatro tem um ou mais stages.
		// Dentro de um stage você vai ter diferentes cenas.
		
		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo"); // Referenciando a classe "titulo".
		
		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("numero");
		
		Button botaoIncremento = new Button("+"); // Criando os botões.
		botaoIncremento.getStyleClass().add("botoes");
		botaoIncremento.setOnAction(e -> {
			contador ++;
			atualizarLabelNumero(labelNumero);
		}); // Setando eventos para o botão.
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		botaoDecremento.setOnAction(e -> {
			contador --;
			atualizarLabelNumero(labelNumero);
		});
		
		HBox boxBotoes = new HBox(); // Definindo o layout da scene.
		boxBotoes.setAlignment(Pos.CENTER); // Setando o alinhamento.
		boxBotoes.setSpacing(10); // Espaçamento do layout.
		boxBotoes.getChildren().add(botaoDecremento); // Adicionando os botões.
		boxBotoes.getChildren().add(botaoIncremento);
		
		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxBotoes.setSpacing(10);
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxBotoes);
		
		String caminhoDoCss = getClass()
				.getResource("/basico/Contador.css").toExternalForm();
		
		Scene cenaPrincipal = new Scene(boxConteudo, 400, 400); // Criando a scene.
		cenaPrincipal.getStylesheets().add(caminhoDoCss); // Setando o estilo da aplicação.
		// Stylesheets é justamente um arquivo css.
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");
		// -> fonts.google.com
		
		primaryStage.setScene(cenaPrincipal); // Definindo a scene utilizada.
		primaryStage.show();
	}

	// É necessário para executar, abrir o pacote no "module-info".
	// Já que o JavaFX faz uma reflection nessa classe.
	public static void main(String[] args) {
		launch(args); 
		// Utilizando o "launch" que recebe o "args" já que eu estou dentro da classe
		//  que será executada.
	}
}
