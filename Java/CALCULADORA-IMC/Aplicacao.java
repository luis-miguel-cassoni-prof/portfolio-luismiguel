import entidades.CalculoIMC;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacao extends Application {

    CalculoIMC calcular = new CalculoIMC();

    @Override 
    public void start(Stage palco) {
        Label titulo = new Label("Calculadora De IMC");
        titulo.getStyleClass().add("titulo");

        Label peso = new Label("Peso: ");
        peso.getStyleClass().add("texto");
        TextField campoPeso = new TextField();
        Label peso2 = new Label("kg");
        peso2.getStyleClass().add("texto");

        Label altura = new Label("Altura: ");
        altura.getStyleClass().add("texto");
        TextField campoAltura = new TextField();
        Label altura2 = new Label("m");
        altura2.getStyleClass().add("texto");

        HBox hBox1 = new HBox(peso, campoPeso, peso2);
        hBox1.setSpacing(8);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(altura, campoAltura, altura2);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(8);

        Button botaoEnviar = new Button("Calcular IMC");
        botaoEnviar.getStyleClass().add("botao");

        Label etiquetaResultado = new Label();
        etiquetaResultado.getStyleClass().add("texto");

        botaoEnviar.setOnAction(e -> {
            try {
                double pesoRecebido = Double.parseDouble(campoPeso.getText().replace(',', '.'));
                double alturaRecebida = Double.parseDouble(campoAltura.getText().replace(',', '.'));

                double imc = calcular.calcularImc(pesoRecebido, alturaRecebida);
            
                etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
            } catch(NumberFormatException err) {
                etiquetaResultado.setText(String.format("O valor informado é nulo"));
            }
        });

        VBox vBox = new VBox(titulo, hBox1, hBox2, botaoEnviar, etiquetaResultado);
        vBox.getStyleClass().add("cena");
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Scene cena = new Scene(vBox, 400, 300);
        cena.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
PARA COMPILAR LOCALMENTE UTILIZE: javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls Aplicacao.java
PARA RODAR LOCALMENTE UTILIZE: java --module-path "%PATH_TO_FX%" --add-modules javafx.controls Aplicacao

REQUISITOS: JDK22, JavaFX 22

Created By: @luismiguelcassoni INSTAGRAM, luis-miguel-cassoni-prof GITHUB
My Linkedin: https://www.linkedin.com/in/lu%C3%ADs-miguel-cassoni-0a217a397/
*/
