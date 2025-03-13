package javafxfinal.componentes.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert; // Importando Alert para exibir mensagens
import javafx.scene.control.Menu; // Importando Menu
import javafx.scene.control.MenuBar; // Importando MenuBar
import javafx.scene.control.RadioMenuItem; // Importando RadioMenuItem
import javafx.scene.control.ToggleGroup; // Importando ToggleGroup
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

public class RadioMenuItemExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação de um MenuBar
        MenuBar menuBar = new MenuBar(); // Inicializando o MenuBar

        // Criação de um Menu
        Menu optionsMenu = new Menu("Opções"); // Criando um Menu com o título "Opções"

        // Criando um ToggleGroup para gerenciar os RadioMenuItems
        ToggleGroup group = new ToggleGroup(); // Inicializando o ToggleGroup

        // Criando RadioMenuItems
        RadioMenuItem option1 = new RadioMenuItem("Opção 1"); // Criando um RadioMenuItem "Opção 1"
        RadioMenuItem option2 = new RadioMenuItem("Opção 2"); // Criando um RadioMenuItem "Opção 2"
        RadioMenuItem option3 = new RadioMenuItem("Opção 3"); // Criando um RadioMenuItem "Opção 3"

        // Atribuindo os RadioMenuItems ao ToggleGroup
        option1.setToggleGroup(group); // Adicionando "Opção 1" ao ToggleGroup
        option2.setToggleGroup(group); // Adicionando "Opção 2" ao ToggleGroup
        option3.setToggleGroup(group); // Adicionando "Opção 3" ao ToggleGroup

        // Ações dos RadioMenuItems
        option1.setOnAction(event -> showAlert("Opção Selecionada", "Você selecionou 'Opção 1'.")); // Ação para "Opção 1"
        option2.setOnAction(event -> showAlert("Opção Selecionada", "Você selecionou 'Opção 2'.")); // Ação para "Opção 2"
        option3.setOnAction(event -> showAlert("Opção Selecionada", "Você selecionou 'Opção 3'.")); // Ação para "Opção 3"

        // Adicionando os RadioMenuItems ao Menu
        optionsMenu.getItems().addAll(option1, option2, option3); // Adicionando os RadioMenuItems ao Menu

        // Adicionando o Menu ao MenuBar
        menuBar.getMenus().add(optionsMenu); // Adicionando o Menu ao MenuBar

        // Configurando o layout
        VBox vbox = new VBox(menuBar); // Criando um VBox e adicionando o MenuBar

        // Criação da cena com o VBox
        Scene scene = new Scene(vbox, 400, 300);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de RadioMenuItem");
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
