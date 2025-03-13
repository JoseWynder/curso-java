package javafxfinal.componentes.navegacao;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Importando Label
import javafx.scene.control.Pagination; // Importando Pagination
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class PaginationExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Total de páginas que o Pagination terá
        int totalPages = 5; // Número de páginas

        // Criação do Pagination
        Pagination pagination = new Pagination(totalPages);

        // Configurando a fábrica para exibir o conteúdo de cada página
        pagination.setPageFactory(this::createPage); // Chama o método createPage para gerar o conteúdo

        // Criação do layout VBox para organizar o Pagination
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().add(pagination); // Adicionando o Pagination ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Pagination");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    // Método para criar o conteúdo de cada página
    private VBox createPage(int pageIndex) {
        // Criação do conteúdo da página
        Label label = new Label("Conteúdo da Página " + (pageIndex + 1)); // Rótulo com o número da página
        VBox page = new VBox(label); // Organiza o conteúdo em um VBox
        page.setStyle("-fx-padding: 20;"); // Define um padding para o conteúdo
        return page; // Retorna a página criada
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
