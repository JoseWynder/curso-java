package javafxfinal.componentes.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu; // Importando Menu
import javafx.scene.control.MenuBar; // Importando MenuBar
import javafx.scene.control.MenuItem; // Importando MenuItem
import javafx.scene.layout.BorderPane; // Importando BorderPane
import javafx.stage.Stage;

public class MenuBarExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do MenuBar
        MenuBar menuBar = new MenuBar();

        // Criação dos menus
        Menu fileMenu = new Menu("Arquivo");
        Menu editMenu = new Menu("Editar");
        Menu helpMenu = new Menu("Ajuda");

        // Criação de itens de menu
        MenuItem newItem = new MenuItem("Novo");
        MenuItem openItem = new MenuItem("Abrir");
        MenuItem exitItem = new MenuItem("Sair");
        MenuItem cutItem = new MenuItem("Recortar");
        MenuItem copyItem = new MenuItem("Copiar");
        MenuItem pasteItem = new MenuItem("Colar");
        MenuItem aboutItem = new MenuItem("Sobre");

        // Adicionando ação ao item "Sair"
        exitItem.setOnAction(event -> {
            System.out.println("Saindo da aplicação...");
            primaryStage.close(); // Fecha a aplicação
        });

        // Adicionando itens aos menus
        fileMenu.getItems().addAll(newItem, openItem, exitItem);
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);
        helpMenu.getItems().add(aboutItem);

        // Adicionando menus ao MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        // Criando um layout BorderPane para organizar os componentes
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar); // Colocando o MenuBar na parte superior

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de MenuBar");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
