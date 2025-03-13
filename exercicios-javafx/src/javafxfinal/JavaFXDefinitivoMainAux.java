package javafxfinal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class JavaFXDefinitivoMainAux extends Application {

    @Override
    public void start(Stage stage) {
    	
        stage.setTitle("Exemplo JavaFX Definitivo");

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);

        
        /*
         * Exibindo um texto informativo com Label.
         */
        Label label = new Label("Bem-vindo ao Exemplo JavaFX!");
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #336699;");

        
        /*
         * Entrada de texto com TextField.
         */
        TextField textField = new TextField();
        textField.setPromptText("Digite algo aqui");

        
        /*
         * Botão para ação.
         */
        Button button = new Button("Mostrar Texto");
        button.setOnAction(e -> {
            String texto = textField.getText();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Você digitou: " + texto);
            alert.showAndWait();
        });

        
        /*
         * Caixa de seleção com CheckBox.
         */
        CheckBox checkBox = new CheckBox("Opção Ativada");

        
        /*
         * Botões de opção com RadioButton.
         */
        ToggleGroup group = new ToggleGroup();
        RadioButton radio1 = new RadioButton("Opção 1");
        RadioButton radio2 = new RadioButton("Opção 2");
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);

        
        /*
         * ComboBox para seleção de valores.
         */
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Item 1", "Item 2", "Item 3");
        comboBox.setValue("Item 1"); // Item padrão selecionado.

        
        /*
         * ListView para exibir uma lista de itens.
         */
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Opção A", "Opção B", "Opção C");
        listView.setPrefHeight(100); // Altura da lista.

        
        /*
         * Barra de Progresso para exibir progresso de tarefas.
         */
        ProgressBar progressBar = new ProgressBar(0.5); // Inicia com 50%.

        
        /*
         * PasswordField para entrada de senha.
         * 
         * O PasswordField permite que o usuário insira uma senha, ocultando o texto
         * digitado.
         */
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Digite sua senha aqui");

        
        /*
         * Botão para mostrar a senha.
         * 
         * Este botão exibirá um alerta com a senha digitada no PasswordField.
         */
        Button showPasswordButton = new Button("Mostrar Senha");
        showPasswordButton.setOnAction(e -> {
            String senha = passwordField.getText();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Sua senha é: " + senha);
            alert.showAndWait();
        });

        
        /*
         * TextArea para entrada de texto em múltiplas linhas.
         * 
         * O TextArea permite que o usuário insira e edite textos longos.
         */
        TextArea textArea = new TextArea();
        textArea.setPromptText("Digite seu texto aqui...");
        textArea.setPrefHeight(100); // Define uma altura preferencial
        textArea.setWrapText(true); // Habilita quebra de linha
        
        
        /*
         * ToggleButton para alternar entre estados.
         * 
         * O ToggleButton é um botão que pode ser ativado ou desativado. 
         * É útil para opções que o usuário pode ligar ou desligar.
         */
        ToggleButton toggleButton = new ToggleButton("Ativar/Desativar");
        toggleButton.setOnAction(e -> {
            if (toggleButton.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("ToggleButton está Desativado!");
                toggleButton.setDisable(true);
                alert.showAndWait();
            }
        });
        
        
        /*
         * ChoiceBox para seleção de opções.
         * 
         * O ChoiceBox permite que o usuário escolha uma opção de uma lista.
         */
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Opção 1", "Opção 2", "Opção 3");
        choiceBox.setValue("Opção 1"); // Define uma opção padrão selecionada

        // Adiciona um evento de ação para mostrar a opção selecionada
        Button showChoiceButton = new Button("Mostrar Opção Selecionada");
        showChoiceButton.setOnAction(e -> {
            String selectedChoice = choiceBox.getValue();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Você selecionou: " + selectedChoice);
            alert.showAndWait();
        });

        
        layout.getChildren().addAll(label, textField, button, checkBox, radio1, radio2, comboBox, listView,
                progressBar, passwordField, showPasswordButton, textArea, toggleButton,choiceBox, showChoiceButton);

        Scene scene = new Scene(layout, 500, 630);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
