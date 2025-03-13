package javafxfinal.componentes.interatividade;

import java.util.Optional; // Importando Optional

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.TextInputDialog; // Importando TextInputDialog
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;

public class DialogExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação de um botão que irá acionar o Dialog
        Button button = new Button("Mostrar Dialog");
        button.setOnAction(event -> showDialog()); // Define a ação ao clicar no botão

        // Criação do layout StackPane para organizar o botão
        StackPane layout = new StackPane();
        layout.getChildren().add(button); // Adicionando o botão ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Dialog");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    // Método para mostrar o Dialog
    private void showDialog() {
        // Criação de um TextInputDialog para capturar entrada do usuário
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Entrada do Usuário"); // Define o título do Dialog
        dialog.setHeaderText("Digite algo:"); // Define o cabeçalho do Dialog
        dialog.setContentText("Conteúdo:"); // Define o conteúdo do Dialog

        // Obtém a resposta do usuário
        Optional<String> result = dialog.showAndWait();

        // Se o usuário pressionar OK, mostra a entrada
        result.ifPresent(input -> System.out.println("Você digitou: " + input));
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
