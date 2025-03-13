package javafxfinal.componentes.graficos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image; // Importando Image
import javafx.scene.image.ImageView; // Importando ImageView
import javafx.scene.layout.StackPane; // Importando StackPane
import javafx.stage.Stage;

public class ImageViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Carregando a imagem a partir de um arquivo
        Image image = new Image("/javafxfinal/componentes/graficos/calculadora.png"); // Substitua pelo caminho da sua imagem

        // Criação do ImageView para exibir a imagem
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300); // Define a largura do ImageView
        imageView.setFitHeight(200); // Define a altura do ImageView
        imageView.setPreserveRatio(true); // Mantém a proporção da imagem

        // Criação do layout StackPane para organizar o ImageView
        StackPane layout = new StackPane();
        layout.getChildren().add(imageView); // Adicionando o ImageView ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 400, 300);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de ImageView");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
