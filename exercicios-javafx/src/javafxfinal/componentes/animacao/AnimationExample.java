package javafxfinal.componentes.animacao;

import javafx.animation.Animation; // Importando Animation
import javafx.animation.TranslateTransition; // Importando TranslateTransition
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.scene.paint.Color; // Importando Color
import javafx.scene.shape.Circle; // Importando Circle
import javafx.stage.Stage;
import javafx.util.Duration; // Importando Duration

public class AnimationExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um círculo
        Circle circle = new Circle(50, Color.BLUE); // Círculo de raio 50 e cor azul

        // Criando uma animação de translação
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), circle); // Duração de 2 segundos
        transition.setByX(200); // Move o círculo 200 pixels para a direita
        transition.setCycleCount(Animation.INDEFINITE); // Animação infinita
        transition.setAutoReverse(true); // Reverte a animação ao final
        transition.play(); // Inicia a animação

        // Criando um StackPane como layout
        StackPane layout = new StackPane();
        layout.getChildren().add(circle); // Adicionando o círculo ao layout

        // Criando a cena
        Scene scene = new Scene(layout, 400, 300); // Tamanho da janela

        // Configurações do Stage
        primaryStage.setTitle("Exemplo de Animation"); // Definindo o título da janela
        primaryStage.setScene(scene); // Definindo a cena do Stage
        primaryStage.show(); // Exibindo a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
