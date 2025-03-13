package javafxfinal.componentes.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker; // Importando DatePicker
import javafx.scene.control.Label; // Importando Label
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

import java.time.LocalDate; // Importando LocalDate

public class DatePickerExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do DatePicker
        DatePicker datePicker = new DatePicker();

        // Criação do Label para exibir a data selecionada
        Label label = new Label("Data selecionada: Nenhuma");

        // Listener para capturar mudanças na data selecionada
        datePicker.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue(); // Obtém a data selecionada
            label.setText("Data selecionada: " + selectedDate); // Atualiza o texto do Label
        });

        // Criação do layout VBox para organizar os componentes
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().addAll(datePicker, label); // Adicionando o DatePicker e o Label ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de DatePicker");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
