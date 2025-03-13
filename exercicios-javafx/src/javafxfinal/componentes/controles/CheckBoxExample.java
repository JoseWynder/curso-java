package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.CheckBox; // Importando CheckBox
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do CheckBox
        CheckBox checkBox = new CheckBox("Aceito os termos e condições");

        // Criação do botão
        Button button = new Button("Mostrar Estado");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Exibindo o estado do CheckBox no console quando o botão é clicado
            if (checkBox.isSelected()) {
                System.out.println("Checkbox está marcado.");
            } else {
                System.out.println("Checkbox não está marcado.");
            }
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(checkBox, button); // Adicionando o CheckBox e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de CheckBox");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
