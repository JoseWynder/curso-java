package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.concurrent.Task; // Importando Task para executar uma tarefa em segundo plano
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.ProgressBar; // Importando ProgressBar
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class ProgressBarExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação da ProgressBar
        ProgressBar progressBar = new ProgressBar(0); // Inicializa a barra com progresso 0

        // Criação do botão para iniciar o processo
        Button button = new Button("Iniciar Progresso");

        // Ação do botão
        button.setOnAction(event -> {
            // Criação de uma tarefa para atualizar o progresso
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    for (int i = 0; i <= 100; i++) {
                        // Atualiza o progresso da barra
                        updateProgress(i, 100); // Atualiza o progresso de 0 a 100
                        Thread.sleep(50); // Simula um atraso
                    }
                    return null;
                }
            };

            // Vincula a ProgressBar à tarefa
            progressBar.progressProperty().bind(task.progressProperty());

            // Inicia a tarefa em um novo Thread
            new Thread(task).start();
        });

        // Criação do layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().addAll(progressBar, button); // Adicionando a ProgressBar e o botão ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 100);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ProgressBar");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
