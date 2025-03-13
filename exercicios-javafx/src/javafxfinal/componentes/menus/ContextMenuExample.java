package javafxfinal.componentes.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.ContextMenu; // Importando ContextMenu
import javafx.scene.control.MenuItem; // Importando MenuItem
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;

public class ContextMenuExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do botão
        Button button = new Button("Clique com o botão direito");

        // Criação do ContextMenu
        ContextMenu contextMenu = new ContextMenu();

        // Criação dos itens do ContextMenu
        MenuItem item1 = new MenuItem("Opção 1");
        MenuItem item2 = new MenuItem("Opção 2");
        MenuItem item3 = new MenuItem("Sair");

        // Ação do item 1
        item1.setOnAction(event -> {
            System.out.println("Opção 1 selecionada.");
        });

        // Ação do item 2
        item2.setOnAction(event -> {
            System.out.println("Opção 2 selecionada.");
        });

        // Ação do item "Sair"
        item3.setOnAction(event -> {
            System.out.println("Saindo da aplicação...");
            primaryStage.close(); // Fecha a aplicação
        });

        // Adicionando itens ao ContextMenu
        contextMenu.getItems().addAll(item1, item2, item3);

        // Adicionando o ContextMenu ao botão
        button.setContextMenu(contextMenu);

        // Criação do layout StackPane para organizar os componentes
        StackPane layout = new StackPane();
        layout.getChildren().add(button); // Adicionando o botão ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ContextMenu");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
