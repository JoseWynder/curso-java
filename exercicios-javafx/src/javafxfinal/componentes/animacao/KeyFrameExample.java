package javafxfinal.componentes.animacao;

import javafx.animation.KeyFrame; // Importando KeyFrame
import javafx.animation.Timeline; // Importando Timeline
import javafx.application.Application; // Importando Application
import javafx.scene.Scene; // Importando Scene
import javafx.scene.layout.Pane; // Importando Pane
import javafx.scene.paint.Color; // Importando Color
import javafx.scene.shape.Rectangle; // Importando Rectangle
import javafx.stage.Stage; // Importando Stage
import javafx.util.Duration; // Importando Duration

public class KeyFrameExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um retângulo
        Rectangle rectangle = new Rectangle(50, 30, Color.RED); // Retângulo vermelho
        rectangle.setX(10); // Posição inicial em X
        rectangle.setY(70); // Posição fixa em Y

        // Criando um Pane para o layout
        Pane pane = new Pane();
        pane.getChildren().add(rectangle); // Adicionando o retângulo ao pane

        // Criando a Timeline
        Timeline timeline = new Timeline(); // Inicializando a Timeline
        timeline.setCycleCount(Timeline.INDEFINITE); // Repetindo indefinidamente

        // Criando KeyFrames para a animação
        KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0), event -> {
            rectangle.setX(10); // Posição inicial do retângulo
            rectangle.setFill(Color.RED); // Cor inicial
        });

        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(2), event -> {
            rectangle.setX(200); // Move o retângulo para a direita
            rectangle.setFill(Color.GREEN); // Muda a cor para verde
        });

        KeyFrame keyFrame3 = new KeyFrame(Duration.seconds(4), event -> {
            rectangle.setX(10); // Retorna o retângulo para a posição inicial
            rectangle.setFill(Color.RED); // Muda a cor de volta para vermelho
        });

        // Adicionando os KeyFrames à Timeline
        timeline.getKeyFrames().addAll(keyFrame1, keyFrame2, keyFrame3);
        timeline.play(); // Inicia a animação

        // Criando a cena
        Scene scene = new Scene(pane, 300, 150); // Tamanho da janela

        // Configurações do Stage
        primaryStage.setTitle("Exemplo de KeyFrame"); // Definindo o título da janela
        primaryStage.setScene(scene); // Definindo a cena do Stage
        primaryStage.show(); // Exibindo a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
