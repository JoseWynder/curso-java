package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.TreeItem; // Importando TreeItem
import javafx.scene.control.TreeView; // Importando TreeView
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) {
        // Criação da raiz da árvore
        TreeItem<String> rootItem = new TreeItem<>("Raiz");
        rootItem.setExpanded(true); // Expande o item raiz

        // Adicionando itens filhos
        TreeItem<String> childItem1 = new TreeItem<>("Filho 1");
        TreeItem<String> childItem2 = new TreeItem<>("Filho 2");
        TreeItem<String> grandChildItem = new TreeItem<>("Neto 1");

        // Montando a estrutura da árvore
        rootItem.getChildren().addAll(childItem1, childItem2);
        childItem1.getChildren().add(grandChildItem);

        // Criação do TreeView
        TreeView<String> treeView = new TreeView<>(rootItem);

        // Criação do botão
        Button button = new Button("Mostrar Item Selecionado");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Exibindo o item selecionado no console quando o botão é clicado
            TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                System.out.println("Item selecionado: " + selectedItem.getValue());
            } else {
                System.out.println("Nenhum item selecionado.");
            }
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(treeView, button); // Adicionando o TreeView e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 300);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de TreeView");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
