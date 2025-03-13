package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker; // Importando ColorPicker
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;
import javafx.scene.paint.Color; // Importando Color

public class ColorPickerExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do StackPane como fundo
        StackPane pane = new StackPane();

        // Criação do ColorPicker
        ColorPicker colorPicker = new ColorPicker();

        // Listener para capturar mudanças na cor selecionada
        colorPicker.setOnAction(event -> {
            Color selectedColor = colorPicker.getValue(); // Obtém a cor selecionada
            pane.setStyle("-fx-background-color: " + toRgbString(selectedColor)); // Atualiza o fundo do pane
        });

        // Adicionando o ColorPicker ao StackPane
        pane.getChildren().add(colorPicker);

        // Criação da cena com o StackPane
        Scene scene = new Scene(pane, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ColorPicker");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    // Método para converter a cor selecionada para uma string RGB
    private String toRgbString(Color color) {
        return String.format("rgb(%d,%d,%d)",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
