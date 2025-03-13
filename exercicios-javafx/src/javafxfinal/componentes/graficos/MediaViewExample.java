package javafxfinal.componentes.graficos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Caminho do arquivo de vídeo (substitua pelo seu arquivo de vídeo)
        String videoPath = "file:///C:/path/to/your/video.mp4"; // Coloque o caminho do seu vídeo aqui
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // Botão para reproduzir/pausar o vídeo
        Button playPauseButton = new Button("Play/Pause");
        playPauseButton.setOnAction(event -> {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause(); // Pausa o vídeo se ele estiver tocando
            } else {
                mediaPlayer.play(); // Inicia a reprodução se o vídeo estiver pausado
            }
        });

        // Configurando o layout
        VBox layout = new VBox(10, mediaView, playPauseButton);
        layout.setAlignment(Pos.CENTER); // Alinhamento central
        layout.setPrefSize(800, 600); // Tamanho preferido da janela

        // Criando a cena e exibindo
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MediaView Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
