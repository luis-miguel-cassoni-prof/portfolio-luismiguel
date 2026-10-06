import gerador.Gerador;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacao extends Application {

    Gerador gerador = new Gerador();

    @Override 
    public void start(Stage palco) {
        Label titulo = new Label("Gerador de Senhas Seguras");
        titulo.getStyleClass().add("titulo");

        Label tamanho = new Label("Tamanho da Senha");
        tamanho.getStyleClass().add("texto");

        TextField vlrTamanho = new TextField();

        Label senhaGerada = new Label();
        senhaGerada.getStyleClass().add("senha");

        TextField senhaParaCopiar = new TextField();
        senhaParaCopiar.getStyleClass().add("texto");

        Button botaoTamanho = new Button("Gerar");
        botaoTamanho.setOnAction(e -> {
            try {
                int quantidade = Integer.parseInt(vlrTamanho.getText());

                if(quantidade < 8) {
                    senhaGerada.setText("A quantidade de digitos não pode ser menor que 8");
                    return;
                }

                String senha = gerador.gerarSenha(quantidade);
                
                senhaGerada.setText("Senha Gerada:");
                senhaParaCopiar.setText(senha);
            } catch (NumberFormatException err) {
                senhaGerada.setText("Erro: uso de caracteres inválido");
            }
        });
        botaoTamanho.getStyleClass().add("botao");


        VBox layout = new VBox(titulo, tamanho, vlrTamanho, botaoTamanho, senhaGerada, senhaParaCopiar);
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("fundo");

        Scene cena = new Scene(layout, 400, 300);
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

REQUISITOS: JDK22, JavaFX 22.0.1

Created By: @luismiguelcassoni INSTAGRAM, luis-miguel-cassoni-prof GITHUB
My Linkedin: https://www.linkedin.com/in/lu%C3%ADs-miguel-cassoni-0a217a397/
*/
