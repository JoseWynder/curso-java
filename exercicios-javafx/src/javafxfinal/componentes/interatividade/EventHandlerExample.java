package javafxfinal.componentes.interatividade;

import javafx.application.Application; // Importando Application
import javafx.scene.Scene; // Importando Scene
import javafx.scene.control.Button; // Importando Button
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage; // Importando Stage
import javafx.event.ActionEvent; // Importando ActionEvent
import javafx.event.EventHandler; // Importando EventHandler

public class EventHandlerExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um botão
        Button button = new Button("Clique em mim"); // Texto do botão
        button.setStyle("-fx-font-size: 16px;"); // Estilo do botão

        // Adicionando um EventHandler ao botão
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Mudando a cor do botão quando clicado
                button.setStyle("-fx-background-color: " + randomColor() + ";");
            }
        });

        // Criando um VBox para o layout
        VBox layout = new VBox(20); // Espaçamento de 20 pixels
        layout.getChildren().add(button); // Adicionando o botão ao layout
        layout.setStyle("-fx-padding: 20;"); // Adicionando padding ao layout

        // Criando a cena
        Scene scene = new Scene(layout, 300, 200); // Tamanho da janela

        // Configurações do Stage
        primaryStage.setTitle("Exemplo de EventHandler"); // Definindo o título da janela
        primaryStage.setScene(scene); // Definindo a cena do Stage
        primaryStage.show(); // Exibindo a janela
    }

    // Método para gerar uma cor aleatória em formato hexadecimal
    private String randomColor() {
        // Gera uma cor aleatória no formato hexadecimal
        int r = (int) (Math.random() * 256); // Valor vermelho entre 0-255
        int g = (int) (Math.random() * 256); // Valor verde entre 0-255
        int b = (int) (Math.random() * 256); // Valor azul entre 0-255
        
        // Converte os valores RGB em hexadecimal
        return String.format("#%02X%02X%02X", r, g, b);
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}

