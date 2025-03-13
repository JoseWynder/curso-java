package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.ComboBox; // Importando ComboBox
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do ComboBox e adição de opções
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Opção 1", "Opção 2", "Opção 3"); // Adicionando opções ao ComboBox

        // Criação do botão
        Button button = new Button("Mostrar Opção Selecionada");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Exibindo a opção selecionada no console quando o botão é clicado
            String selectedOption = comboBox.getSelectionModel().getSelectedItem();
            if (selectedOption != null) {
                System.out.println("Opção selecionada: " + selectedOption);
            } else {
                System.out.println("Nenhuma opção selecionada.");
            }
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(comboBox, button); // Adicionando o ComboBox e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ComboBox");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
