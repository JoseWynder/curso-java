package javafxfinal.componentes.graficos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas; // Importando Canvas
import javafx.scene.canvas.GraphicsContext; // Importando GraphicsContext
import javafx.scene.input.MouseEvent; // Importando MouseEvent
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;

public class CanvasExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do Canvas com largura e altura
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D(); // Obtendo o contexto gráfico do Canvas

        // Listener para desenhar ao arrastar o mouse
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            // Desenha uma linha da posição anterior para a posição atual do mouse
            gc.lineTo(event.getX(), event.getY());
            gc.stroke(); // Finaliza o desenho da linha
        });

        // Inicia o desenho quando o mouse é pressionado
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            gc.beginPath(); // Inicia um novo caminho para o desenho
            gc.moveTo(event.getX(), event.getY()); // Move para a posição do mouse
        });

        // Criação do layout StackPane para organizar o Canvas
        StackPane layout = new StackPane();
        layout.getChildren().add(canvas); // Adicionando o Canvas ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 400, 400);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Canvas");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
