package javafxfinal.componentes.geral;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.Separator; // Importando Separator
import javafx.scene.layout.HBox; // Importando HBox
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class SeparatorExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando botões para o exemplo
        Button button1 = new Button("Botão 1"); // Botão 1
        Button button2 = new Button("Botão 2"); // Botão 2
        Button button3 = new Button("Botão 3"); // Botão 3

        // Criando um Separator horizontal
        Separator horizontalSeparator = new Separator(); // Separator horizontal

        // Criando um HBox com os botões
        HBox hBox = new HBox(10); // HBox com espaçamento de 10
        hBox.getChildren().addAll(button1, button2); // Adicionando botões ao HBox

        // Criando um Separator vertical
        Separator verticalSeparator = new Separator(); // Separator vertical
        verticalSeparator.setOrientation(javafx.geometry.Orientation.VERTICAL); // Definindo a orientação como vertical

        // Criando um VBox para organizar os elementos
        VBox vBox = new VBox(10); // VBox com espaçamento de 10
        vBox.getChildren().addAll(hBox, horizontalSeparator, button3); // Adicionando HBox, Separator e o botão 3 ao VBox

        // Criação da cena com o VBox
        Scene scene = new Scene(vBox, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Separator");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
