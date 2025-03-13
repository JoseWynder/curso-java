package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Importando Label
import javafx.scene.control.Hyperlink; // Importando Hyperlink
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class HyperlinkExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do Hyperlink
        Hyperlink hyperlink = new Hyperlink("Clique aqui para ver a mensagem");
        
        // Criação do Label para exibir a mensagem
        Label label = new Label();

        // Listener para capturar cliques no Hyperlink
        hyperlink.setOnAction(event -> {
            label.setText("Você clicou no hyperlink!"); // Atualiza o texto do Label
        });

        // Criação do layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().addAll(hyperlink, label); // Adicionando o Hyperlink e o Label ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Hyperlink");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
