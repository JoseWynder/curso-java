package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton; // Importando ToggleButton
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;
import javafx.scene.paint.Color; // Importando Color

public class ToggleButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um ToggleButton
        ToggleButton toggleButton = new ToggleButton("Ativar Cor"); // Criando um ToggleButton com texto

        // Criando um StackPane para organizar o ToggleButton
        StackPane layout = new StackPane(); // Inicializando o StackPane
        layout.getChildren().add(toggleButton); // Adicionando o ToggleButton ao StackPane

        // Adicionando ação ao ToggleButton
        toggleButton.setOnAction(event -> { // Definindo o que acontece ao ativar/desativar
            if (toggleButton.isSelected()) { // Verificando se o ToggleButton está ativado
                layout.setStyle("-fx-background-color: lightgreen;"); // Mudando a cor de fundo
            } else {
                layout.setStyle("-fx-background-color: lightcoral;"); // Mudando a cor de fundo
            }
        });

        // Criação da cena com o StackPane
        Scene scene = new Scene(layout, 400, 300, Color.LIGHTGRAY); // Cena com fundo cinza claro
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ToggleButton");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
