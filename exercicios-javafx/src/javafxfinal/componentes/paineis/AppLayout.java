package javafxfinal.componentes.paineis;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxfinal.componentes.paineis.paineis.TesteTilePane;

public class AppLayout extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent raiz = null;
		
//		raiz = new TesteAnchorPane();
//		raiz = new TesteBorderPane();
//		raiz = new TesteFlowPane();
//		raiz = new TesteGridPane();
//		raiz = new TesteStackPane();
		raiz = new TesteTilePane();
		
		
//		VBox temp = new VBox();
//		temp.getChildren().add(new Caixa().comTexto("1")); // Se expande.
//		temp.getChildren().add(new Quadrado()); // Tamanho fixo.
			// Shape não aceita texto dentro dele.
		
		
		Scene principal = new Scene(raiz, 800, 600);
		primaryStage.setScene(principal);
		primaryStage.setTitle("Gerenciadores de Layout");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
