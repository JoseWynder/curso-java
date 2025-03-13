package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.concurrent.Task; // Importando Task
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.ProgressIndicator; // Importando ProgressIndicator
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class ProgressIndicatorExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um ProgressIndicator
        ProgressIndicator progressIndicator = new ProgressIndicator(0); // Inicializando com 0%
        
        // Criando um botão para iniciar o processo
        Button startButton = new Button("Iniciar Carregamento"); // Criando o botão
        startButton.setOnAction(event -> {
            // Iniciar um novo Task para simular o carregamento
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50); // Simula tempo de carregamento
                        updateProgress(i, 100); // Atualiza o progresso
                    }
                    return null;
                }
            };

            // Ligando o progresso do Task ao ProgressIndicator
            progressIndicator.progressProperty().bind(task.progressProperty());

            // Executando o Task em uma nova Thread
            new Thread(task).start();
        });

        // Organizando os elementos em um VBox
        VBox layout = new VBox(10, startButton, progressIndicator); // VBox com espaçamento de 10
        layout.setStyle("-fx-padding: 20;"); // Adicionando espaçamento na VBox

        // Criação da cena com o VBox
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ProgressIndicator");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
