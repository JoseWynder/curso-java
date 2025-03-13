package javafxfinal.componentes.interatividade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert; // Importando Alert
import javafx.scene.control.Alert.AlertType; // Importando AlertType
import javafx.scene.control.Button; // Importando Button
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;

public class AlertExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação de um botão que irá acionar o Alert
        Button button = new Button("Mostrar Alerta");
        button.setOnAction(event -> showAlert()); // Define a ação ao clicar no botão

        // Criação do layout StackPane para organizar o botão
        StackPane layout = new StackPane();
        layout.getChildren().add(button); // Adicionando o botão ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Alert");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    // Método para mostrar o Alert
    private void showAlert() {
        Alert alert = new Alert(AlertType.INFORMATION); // Criação do Alert de tipo informação
        alert.setTitle("Título do Alerta"); // Define o título do Alert
        alert.setHeaderText("Cabeçalho do Alerta"); // Define o cabeçalho do Alert
        alert.setContentText("Este é o conteúdo do alerta!"); // Define o conteúdo do Alert
        
        alert.showAndWait(); // Mostra o Alert e espera a ação do usuário
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
