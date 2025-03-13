package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.RadioButton; // Importando RadioButton
import javafx.scene.control.ToggleGroup; // Importando ToggleGroup
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação de um ToggleGroup para agrupar os RadioButtons
        ToggleGroup toggleGroup = new ToggleGroup();

        // Criação dos RadioButtons
        RadioButton radioButton1 = new RadioButton("Opção 1");
        radioButton1.setToggleGroup(toggleGroup); // Adicionando ao ToggleGroup

        RadioButton radioButton2 = new RadioButton("Opção 2");
        radioButton2.setToggleGroup(toggleGroup); // Adicionando ao ToggleGroup

        RadioButton radioButton3 = new RadioButton("Opção 3");
        radioButton3.setToggleGroup(toggleGroup); // Adicionando ao ToggleGroup

        // Criação do botão
        Button button = new Button("Mostrar Opção Selecionada");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Verificando qual RadioButton está selecionado e exibindo no console
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                System.out.println("Opção selecionada: " + selectedRadioButton.getText());
            } else {
                System.out.println("Nenhuma opção selecionada.");
            }
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(radioButton1, radioButton2, radioButton3, button); // Adicionando os RadioButtons e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de RadioButton");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
