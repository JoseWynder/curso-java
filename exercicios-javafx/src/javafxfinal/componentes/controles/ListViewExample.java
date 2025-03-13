package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.ListView; // Importando ListView
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do ListView e adição de opções
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Item 1", "Item 2", "Item 3", "Item 4"); // Adicionando itens ao ListView

        // Criação do botão
        Button button = new Button("Mostrar Item Selecionado");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Exibindo o item selecionado no console quando o botão é clicado
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                System.out.println("Item selecionado: " + selectedItem);
            } else {
                System.out.println("Nenhum item selecionado.");
            }
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(listView, button); // Adicionando o ListView e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ListView");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
