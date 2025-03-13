package javafxfinal.componentes.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.CheckBox; // Importando CheckBox
import javafx.scene.control.ToolBar; // Importando ToolBar
import javafx.scene.layout.BorderPane; // Importando BorderPane
import javafx.stage.Stage;

public class ToolBarExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do ToolBar
        ToolBar toolBar = new ToolBar();

        // Criação dos botões
        Button button1 = new Button("Botão 1");
        Button button2 = new Button("Botão 2");
        
        // Criação de uma CheckBox
        CheckBox checkBox = new CheckBox("Ativar opção");

        // Adicionando ações aos botões
        button1.setOnAction(event -> {
            System.out.println("Botão 1 clicado.");
        });

        button2.setOnAction(event -> {
            System.out.println("Botão 2 clicado.");
        });

        // Adicionando os botões e a CheckBox ao ToolBar
        toolBar.getItems().addAll(button1, button2, checkBox);

        // Criação do layout BorderPane para organizar os componentes
        BorderPane layout = new BorderPane();
        layout.setTop(toolBar); // Colocando o ToolBar na parte superior

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ToolBar");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
