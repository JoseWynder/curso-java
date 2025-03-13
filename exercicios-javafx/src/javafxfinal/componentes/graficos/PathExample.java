package javafxfinal.componentes.graficos;

import javafx.application.Application; // Importando Application
import javafx.scene.Scene; // Importando Scene
import javafx.scene.layout.Pane; // Importando Pane
import javafx.scene.paint.Color; // Importando Color
import javafx.scene.shape.LineTo; // Importando LineTo
import javafx.scene.shape.MoveTo; // Importando MoveTo
import javafx.scene.shape.Path; // Importando Path
import javafx.stage.Stage; // Importando Stage

public class PathExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um objeto Path
        Path path = new Path(); // Cria um novo objeto Path
        
        // Movendo para a posição inicial (10, 10)
        MoveTo moveTo = new MoveTo(10, 10); // MoveTo para (10, 10)
        // Desenhando linhas para criar uma forma
        LineTo line1 = new LineTo(100, 10); // Linha para (100, 10)
        LineTo line2 = new LineTo(100, 100); // Linha para (100, 100)
        LineTo line3 = new LineTo(10, 100); // Linha para (10, 100)
        LineTo line4 = new LineTo(10, 10); // Linha de volta para o ponto inicial

        // Adicionando os pontos ao Path
        path.getElements().add(moveTo); // Adiciona MoveTo
        path.getElements().add(line1); // Adiciona a primeira linha
        path.getElements().add(line2); // Adiciona a segunda linha
        path.getElements().add(line3); // Adiciona a terceira linha
        path.getElements().add(line4); // Adiciona a quarta linha

        // Definindo o preenchimento e a cor da borda do Path
        path.setFill(Color.LIGHTBLUE); // Cor de preenchimento
        path.setStroke(Color.BLUE); // Cor da borda
        path.setStrokeWidth(2); // Largura da borda

        // Criando um Pane para adicionar o Path
        Pane pane = new Pane(); // Cria um novo Pane
        pane.getChildren().add(path); // Adiciona o Path ao Pane

        // Criando a cena
        Scene scene = new Scene(pane, 200, 200); // Tamanho da janela

        // Configurações do Stage
        primaryStage.setTitle("Exemplo de Path"); // Definindo o título da janela
        primaryStage.setScene(scene); // Definindo a cena do Stage
        primaryStage.show(); // Exibindo a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
