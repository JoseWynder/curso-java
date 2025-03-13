package javafxfinal.componentes.graficos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.layout.BorderPane; // Importando BorderPane
import javafx.scene.web.WebEngine; // Importando WebEngine
import javafx.scene.web.WebView; // Importando WebView
import javafx.stage.Stage;

public class WebViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criando um WebView
        WebView webView = new WebView(); // Inicializando o WebView
        WebEngine webEngine = webView.getEngine(); // Obtendo o WebEngine do WebView

        // Carregando uma página da web
        webEngine.load("https://www.youtube.com"); // Substitua pela URL desejada

        // Criando um botão para recarregar a página
        Button reloadButton = new Button("Recarregar Página"); // Criando o botão
        reloadButton.setOnAction(event -> webEngine.reload()); // Recarregando a página ao clicar no botão

        // Organizando os elementos em um BorderPane
        BorderPane layout = new BorderPane(); // Inicializando o BorderPane
        layout.setCenter(webView); // Adicionando o WebView ao centro
        layout.setTop(reloadButton); // Adicionando o botão na parte superior

        // Criação da cena com o BorderPane
        Scene scene = new Scene(layout, 800, 600); // Tamanho da janela

        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de WebView");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
