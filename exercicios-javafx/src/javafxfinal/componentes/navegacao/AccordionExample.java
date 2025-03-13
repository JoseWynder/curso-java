package javafxfinal.componentes.navegacao;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion; // Importando Accordion
import javafx.scene.control.TitledPane; // Importando TitledPane
import javafx.scene.control.Label; // Importando Label
import javafx.scene.layout.VBox; // Importando VBox
import javafx.stage.Stage;

/**
 * AccordionExample:
 * Esta classe demonstra como criar um Accordion,
 * que é uma coleção de TitledPanes onde apenas uma seção pode estar expandida por vez.
 * Ideal para exibir informações agrupadas de forma compacta.
 */
public class AccordionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criação do Accordion
        Accordion accordion = new Accordion();

        // Criação das seções (TitledPanes)
        TitledPane pane1 = new TitledPane("Seção 1", new Label("Conteúdo da Seção 1"));
        TitledPane pane2 = new TitledPane("Seção 2", new Label("Conteúdo da Seção 2"));

        // Adicionando as seções ao Accordion
        accordion.getPanes().addAll(pane1, pane2);

        // Criação do layout VBox para organizar o Accordion
        VBox layout = new VBox(10); // 10 é o espaço entre os componentes
        layout.getChildren().add(accordion); // Adicionando o Accordion ao layout

        // Criação da cena com o layout
        Scene scene = new Scene(layout, 300, 200);
        
        // Configurações da janela principal
        primaryStage.setTitle("Exemplo de Accordion");
        primaryStage.setScene(scene);
        primaryStage.show(); // Exibe a janela
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
