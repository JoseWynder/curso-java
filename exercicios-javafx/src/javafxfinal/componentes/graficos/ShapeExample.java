package javafxfinal.componentes.graficos;

import javafx.application.Application; // Importando Application
import javafx.scene.Scene; // Importando Scene
import javafx.scene.layout.Pane; // Importando Pane
import javafx.scene.paint.Color; // Importando Color
import javafx.scene.shape.Circle; // Importando Circle
import javafx.scene.shape.Rectangle; // Importando Rectangle
import javafx.stage.Stage; // Importando Stage

public class ShapeExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um círculo
        Circle circle = new Circle(50); // Raio do círculo
        circle.setFill(Color.GREEN); // Cor de preenchimento
        circle.setStroke(Color.BLACK); // Cor da borda
        circle.setStrokeWidth(2); // Largura da borda
        circle.setCenterX(100); // Posição X do centro
        circle.setCenterY(100); // Posição Y do centro

        // Criando um retângulo
        Rectangle rectangle = new Rectangle(150, 50, 100, 80); // (x, y, largura, altura)
        rectangle.setFill(Color.BLUE); // Cor de preenchimento
        rectangle.setStroke(Color.BLACK); // Cor da borda
        rectangle.setStrokeWidth(2); // Largura da borda

        // Criando um Pane para adicionar as formas
        Pane pane = new Pane(); // Cria um novo Pane
        pane.getChildren().addAll(circle, rectangle); // Adiciona o círculo e o retângulo ao Pane

        // Criando a cena
        Scene scene = new Scene(pane, 400, 200); // Tamanho da janela

        // Configurações do Stage
        primaryStage.setTitle("Exemplo de Shape"); // Definindo o título da janela
        primaryStage.setScene(scene); // Definindo a cena do Stage
        primaryStage.show(); // Exibindo a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
