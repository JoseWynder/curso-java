package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Importando Label
import javafx.scene.control.Spinner; // Importando Spinner
import javafx.scene.control.SpinnerValueFactory; // Importando SpinnerValueFactory
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class SpinnerExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do Spinner com intervalo de 0 a 10
        Spinner<Integer> spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0)); // Mínimo, máximo e valor inicial

        // Criação do Label para exibir o valor selecionado
        Label label = new Label("Valor selecionado: 0");

        // Listener para capturar mudanças no valor do Spinner
        spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            label.setText("Valor selecionado: " + newValue); // Atualiza o texto do Label
        });

        // Criação do layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().addAll(spinner, label); // Adicionando o Spinner e o Label ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Spinner");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
