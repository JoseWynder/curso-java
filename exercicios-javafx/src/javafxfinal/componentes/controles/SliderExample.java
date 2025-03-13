package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Importando Label
import javafx.scene.control.Slider; // Importando Slider
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class SliderExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do Slider com valores de 0 a 100
        Slider slider = new Slider(0, 100, 50); // Min, Max, Valor inicial
        slider.setShowTickLabels(true); // Mostra os rótulos dos ticks
        slider.setShowTickMarks(true); // Mostra as marcas dos ticks

        // Criação do Label para exibir o valor do Slider
        Label label = new Label("Valor do Slider: " + slider.getValue());

        // Atualiza o Label sempre que o Slider é movido
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            label.setText("Valor do Slider: " + newValue.intValue()); // Atualiza o texto do Label
        });

        // Criação do layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().addAll(slider, label); // Adicionando o Slider e o Label ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 100);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Slider");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
