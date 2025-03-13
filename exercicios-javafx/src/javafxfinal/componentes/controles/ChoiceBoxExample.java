package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox; // Importando ChoiceBox
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;
import javafx.scene.paint.Color; // Importando Color

public class ChoiceBoxExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um StackPane para organizar o ChoiceBox
        StackPane layout = new StackPane(); // Inicializando o StackPane
        
        // Criando um ChoiceBox com opções de cores
        ChoiceBox<String> colorChoiceBox = new ChoiceBox<>(); // Criando o ChoiceBox
        colorChoiceBox.getItems().addAll("Vermelho", "Verde", "Azul", "Amarelo"); // Adicionando opções
        
        // Adicionando ação ao ChoiceBox
        colorChoiceBox.setOnAction(event -> { // Definindo o que acontece ao selecionar uma opção
            String selectedColor = colorChoiceBox.getValue(); // Obtendo o valor selecionado
            
            // Mudando a cor de fundo da cena com base na escolha
            switch (selectedColor) {
                case "Vermelho":
                    layout.setStyle("-fx-background-color: red;"); // Fundo vermelho
                    break;
                case "Verde":
                    layout.setStyle("-fx-background-color: green;"); // Fundo verde
                    break;
                case "Azul":
                    layout.setStyle("-fx-background-color: blue;"); // Fundo azul
                    break;
                case "Amarelo":
                    layout.setStyle("-fx-background-color: yellow;"); // Fundo amarelo
                    break;
            }
        });

        layout.getChildren().add(colorChoiceBox); // Adicionando o ChoiceBox ao StackPane

        // Criação da cena com o StackPane
        Scene scene = new Scene(layout, 400, 300, Color.LIGHTGRAY); // Cena com fundo cinza claro
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ChoiceBox");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
