package javafxfinal.componentes.interatividade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.Tooltip; // Importando Tooltip
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class TooltipExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do Button
        Button button = new Button("Passe o mouse aqui");

        // Criação do Tooltip
        Tooltip tooltip = new Tooltip("Este é um botão. Clique para executar uma ação.");
        Tooltip.install(button, tooltip); // Associando o Tooltip ao Button

        // Criação do layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().add(button); // Adicionando o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Tooltip");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
