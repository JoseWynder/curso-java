package javafxfinal.componentes.animacao;

import javafx.animation.KeyFrame; // Importando KeyFrame
import javafx.animation.Timeline; // Importando Timeline
import javafx.application.Application; // Importando Application
import javafx.scene.Scene; // Importando Scene
import javafx.scene.layout.Pane; // Importando Pane
import javafx.scene.paint.Color; // Importando Color
import javafx.scene.shape.Circle; // Importando Circle
import javafx.stage.Stage; // Importando Stage
import javafx.util.Duration; // Importando Duration

public class TimelineExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um círculo
        Circle circle = new Circle(20, Color.BLUE); // Círculo azul com raio 20
        circle.setCenterX(20); // Posição inicial em X
        circle.setCenterY(100); // Posição fixa em Y

        // Criando um Pane para o layout
        Pane pane = new Pane();
        pane.getChildren().add(circle); // Adicionando o círculo ao pane

        // Criando a Timeline
        Timeline timeline = new Timeline(); // Inicializando a Timeline
        timeline.setCycleCount(Timeline.INDEFINITE); // Repetindo indefinidamente

        // Criando um KeyFrame para a animação
        KeyFrame keyFrame = new KeyFrame(Duration.millis(20), event -> {
            // Atualizando a posição do círculo
            circle.setCenterX(circle.getCenterX() + 1); // Move o círculo para a direita
            // Reseta a posição ao chegar no final da janela
            if (circle.getCenterX() > 400) {
                circle.setCenterX(20); // Volta para a posição inicial
            }
        });

        timeline.getKeyFrames().add(keyFrame); // Adicionando o KeyFrame à Timeline
        timeline.play(); // Inicia a animação

        // Criando a cena
        Scene scene = new Scene(pane, 400, 200); // Tamanho da janela

        // Configurações do Stage
        primaryStage.setTitle("Exemplo de Timeline"); // Definindo o título da janela
        primaryStage.setScene(scene); // Definindo a cena do Stage
        primaryStage.show(); // Exibindo a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
