package javafxfinal.componentes.navegacao;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab; // Importando Tab
import javafx.scene.control.TabPane; // Importando TabPane
import javafx.scene.control.Label; // Importando Label
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage; // Importando Stage

/**
 * TabPaneExample:
 * Esta classe demonstra como criar um TabPane com múltiplas abas,
 * onde cada aba contém conteúdo centralizado utilizando StackPane.
 * É ideal para aplicações que requerem uma organização em abas.
 */
public class TabPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do TabPane
        TabPane tabPane = new TabPane();

        // Criação da primeira aba
        Tab tab1 = new Tab("Aba 1");
        Label label1 = new Label("Conteúdo da Aba 1"); // Conteúdo da Aba 1
        StackPane stackPane1 = new StackPane(label1); // Usando StackPane para centralizar o conteúdo
        tab1.setContent(stackPane1); // Adicionando o conteúdo à Aba 1

        // Criação da segunda aba
        Tab tab2 = new Tab("Aba 2");
        Label label2 = new Label("Conteúdo da Aba 2"); // Conteúdo da Aba 2
        StackPane stackPane2 = new StackPane(label2); // Usando StackPane para centralizar o conteúdo
        tab2.setContent(stackPane2); // Adicionando o conteúdo à Aba 2

        // Adicionando as abas ao TabPane
        tabPane.getTabs().addAll(tab1, tab2);

        // Criação da cena com o TabPane
        Scene scene = new Scene(tabPane, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de TabPane");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
