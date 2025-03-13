package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.geometry.Pos; // Import necessário para Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importando Button
import javafx.scene.control.TableColumn; // Importando TableColumn
import javafx.scene.control.TableView; // Importando TableView
import javafx.scene.control.cell.PropertyValueFactory; // Importando PropertyValueFactory
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewExample extends Application {

    // Classe interna para representar os dados da tabela
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Criação do TableView
        TableView<Person> tableView = new TableView<>();

        // Criação das colunas da tabela
        TableColumn<Person, String> nameColumn = new TableColumn<>("Nome");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); // Mapeando a propriedade name

        TableColumn<Person, Integer> ageColumn = new TableColumn<>("Idade");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age")); // Mapeando a propriedade age

        // Adicionando colunas ao TableView
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(ageColumn);

        // Adicionando dados à tabela
        tableView.getItems().addAll(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 28)
        );

        // Criação do botão
        Button button = new Button("Mostrar Dados Selecionados");
        
        // Adicionando um EventHandler ao botão
        button.setOnAction(event -> {
            // Exibindo os dados da linha selecionada no console quando o botão é clicado
            Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
            if (selectedPerson != null) {
                System.out.println("Nome: " + selectedPerson.getName() + ", Idade: " + selectedPerson.getAge());
            } else {
                System.out.println("Nenhuma linha selecionada.");
            }
        });

        // Criação de um layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.setAlignment(Pos.CENTER); // Alinhando os componentes ao centro
        layout.getChildren().addAll(tableView, button); // Adicionando o TableView e o Button ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 300);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de TableView");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
