import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ProjetoMiniNavegador extends Application {

    @Override 
    public void start(Stage palco) {
        TextField campoUrl = new TextField();
        WebView navegador = new WebView();
        WebEngine motor = navegador.getEngine();

        campoUrl.setOnAction(e -> {
            motor.load(formataUrl(campoUrl.getText()));
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(campoUrl, navegador);

        Scene cena = new Scene(layout);

        palco.setScene(cena);
        palco.setTitle("Mini Navegador Web Java");
        palco.show();
    }

    public String formataUrl(String url) {
        if(!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        return url;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
PARA COMPILAR LOCALMENTE UTILIZE: javac --module-path "%PATH_TO_FX%" --add-modules javafx.web ProjetoMiniNavegador.java
PARA RODAR LOCALMENTE UTILIZE: java --module-path "%PATH_TO_FX%" --add-modules javafx.web ProjetoMiniNavegador

REQUISITOS: JDK22, JavaFX 22

Created By: @luismiguelcassoni INSTAGRAM, luis-miguel-cassoni-prof GITHUB
My Linkedin: https://www.linkedin.com/in/lu%C3%ADs-miguel-cassoni-0a217a397/
*/
