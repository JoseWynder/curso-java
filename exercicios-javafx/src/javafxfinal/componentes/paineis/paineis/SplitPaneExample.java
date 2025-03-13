package javafxfinal.componentes.paineis.paineis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Importando Label
import javafx.scene.control.SplitPane; // Importando SplitPane
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class SplitPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um SplitPane
        SplitPane splitPane = new SplitPane(); // Inicializando o SplitPane

        // Criando um Label para a parte esquerda
        Label textLabel = new Label("Texto na parte esquerda"); // Texto explicativo
        VBox leftBox = new VBox(textLabel); // Organizando o texto em um VBox

        // Criando uma imagem para a parte direita
        Label image = new Label("Texto na parte direita"); // Carregando a imagem (substitua pelo caminho da sua imagem)
        VBox rightBox = new VBox(image); // Organizando o texto em um VBox
        
        // Adicionando os elementos ao SplitPane
        splitPane.getItems().addAll(leftBox, rightBox); // Adicionando o VBox e o ImageView ao SplitPane

        // Criação da cena com o SplitPane
        Scene scene = new Scene(splitPane, 400, 300);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de SplitPane");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
