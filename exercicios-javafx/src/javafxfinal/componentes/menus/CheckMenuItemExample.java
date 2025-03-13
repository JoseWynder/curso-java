package javafxfinal.componentes.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert; // Importando Alert para exibir mensagens
import javafx.scene.control.CheckMenuItem; // Importando CheckMenuItem
import javafx.scene.control.Menu; // Importando Menu
import javafx.scene.control.MenuBar; // Importando MenuBar
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class CheckMenuItemExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação de um MenuBar
        MenuBar menuBar = new MenuBar(); // Inicializando o MenuBar

        // Criação de um Menu
        Menu optionsMenu = new Menu("Opções"); // Criando um Menu com o título "Opções"

        // Criando CheckMenuItems
        CheckMenuItem checkItem1 = new CheckMenuItem("Mostrar A"); // Criando um CheckMenuItem "Mostrar A"
        CheckMenuItem checkItem2 = new CheckMenuItem("Mostrar B"); // Criando um CheckMenuItem "Mostrar B"

        // Ações dos CheckMenuItems
        checkItem1.setOnAction(event -> showAlert("Opção Selecionada", 
            checkItem1.isSelected() ? "Você ativou 'Mostrar A'." : "Você desativou 'Mostrar A'.")); // Ação para "Mostrar A"
        
        checkItem2.setOnAction(event -> showAlert("Opção Selecionada", 
            checkItem2.isSelected() ? "Você ativou 'Mostrar B'." : "Você desativou 'Mostrar B'.")); // Ação para "Mostrar B"

        // Adicionando os CheckMenuItems ao Menu
        optionsMenu.getItems().addAll(checkItem1, checkItem2); // Adicionando os CheckMenuItems ao Menu

        // Adicionando o Menu ao MenuBar
        menuBar.getMenus().add(optionsMenu); // Adicionando o Menu ao MenuBar

        // Configurando o layout
        VBox vbox = new VBox(menuBar); // Criando um VBox e adicionando o MenuBar

        // Criação da cena com o VBox
        Scene scene = new Scene(vbox, 400, 300);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de CheckMenuItem");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    // Método para mostrar um Alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Criando um Alert do tipo informação
        alert.setTitle(title); // Definindo o título do Alert
        alert.setHeaderText(null); // Sem cabeçalho
        alert.setContentText(message); // Definindo o conteúdo do Alert
        alert.showAndWait(); // Exibindo o Alert
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
