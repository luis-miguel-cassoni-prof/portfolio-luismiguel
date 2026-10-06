
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProjetoRelogioDigital extends Application {
    final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override 
    public void start(Stage palco) {
        Label titulo = new Label("Relógio Digital");
        titulo.getStyleClass().add("titulo");

        Label rotuloTempo = new Label();
        rotuloTempo.getStyleClass().add("rotulo-tempo");

        KeyFrame atualizar = new KeyFrame(Duration.ZERO, e -> {
            rotuloTempo.setText(LocalDateTime.now().format(FORMATADOR));
        });

        KeyFrame intervalo = new KeyFrame(Duration.seconds(1));

        Timeline relogio = new Timeline();
        relogio.getKeyFrames().addAll(atualizar, intervalo);

        relogio.setCycleCount(Animation.INDEFINITE);
        relogio.play();

        VBox layout = new VBox(titulo, rotuloTempo);
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("fundo");

        Scene cena = new Scene(layout, 200, 200);
        cena.getStylesheets().add("style.css");

        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
