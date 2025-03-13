package javafxfinal.componentes.navegacao;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Importando Label
import javafx.scene.layout.VBox; // Importando VBox
import javafx.scene.control.ScrollPane; // Importando ScrollPane
import javafx.stage.Stage;

public class ScrollPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um VBox para organizar os elementos
        VBox layout = new VBox(10); // Espaçamento de 10 entre os elementos

        // Criando Labels para simular uma lista de itens
        for (int i = 0; i < 100; i++) {
            Label label = new Label("Item " + (i + 1)); // Criando labels
            layout.getChildren().add(label); // Adicionando as labels ao layout
        }

        // Criando um ScrollPane e adicionando o VBox a ele
        ScrollPane scrollPane = new ScrollPane(layout); // Adicionando o layout ao ScrollPane
        scrollPane.setFitToWidth(true); // Ajusta a largura do ScrollPane

        // Criação da cena com o ScrollPane
        Scene scene = new Scene(scrollPane, 300, 400); // Tamanho da janela

        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ScrollPane");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
