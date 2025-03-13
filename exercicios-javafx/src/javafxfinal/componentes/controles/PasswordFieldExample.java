package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.PasswordField; // Importando PasswordField
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordFieldExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do PasswordField para entrada de senha
        PasswordField passwordField = new PasswordField(); // Campo de senha vazio

        // Criação do botão
        Button button = new Button("Mostrar Senha");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Exibindo a senha digitada no console quando o botão é clicado
            System.out.println("Senha digitada: " + passwordField.getText());
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(passwordField, button); // Adicionando o PasswordField e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de PasswordField");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
