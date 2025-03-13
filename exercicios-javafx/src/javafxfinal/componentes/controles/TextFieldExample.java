package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.TextField; // Importando TextField
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do TextField para entrada de texto
        TextField textField = new TextField(); // Campo de texto vazio
        textField.setPromptText("Digite seu texto aqui..."); // Texto de sugestão

        // Criação do botão
        Button button = new Button("Mostrar Texto");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Exibindo o texto digitado no console quando o botão é clicado
            System.out.println("Texto digitado: " + textField.getText());
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(textField, button); // Adicionando o TextField e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de TextField");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
