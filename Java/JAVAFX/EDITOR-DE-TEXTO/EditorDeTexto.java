import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditorDeTexto extends Application {
    
    @Override 
    public void start(Stage palco) {
        TextArea campoTexto = new TextArea();

        Button botaoAbrir = new Button("Abrir");
        botaoAbrir.getStyleClass().add("botao");

        Button botaoSalvar = new Button("Salvar");
        botaoSalvar.getStyleClass().add("botao");

        FileChooser selecionarArquivo = new FileChooser();
        selecionarArquivo.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos TXT (*.txt)", "*.txt"));

        selecionarArquivo.setTitle("Arquivos de Texto");

        botaoAbrir.setOnAction(e -> {
            File arquivoSelecionado = selecionarArquivo.showOpenDialog(palco);

            if(arquivoSelecionado != null) {
                try {
                    String texto = Files.readString(arquivoSelecionado.toPath());
                    campoTexto.setText(texto);
                } catch (IOException err) {
                    campoTexto.setText("Falha ao ler arquivo");
                }
            }
        });

        botaoSalvar.setOnAction(e -> {
            File arquivoSelecionado = selecionarArquivo.showSaveDialog(palco);

            if(arquivoSelecionado != null) {
                try {
                    String texto = campoTexto.getText();

                    Files.writeString(arquivoSelecionado.toPath(), texto);
                } catch (IOException err) {
                    campoTexto.setText("Falha ao gravar arquivo");
                }
            }
        });

        HBox hBox = new HBox(botaoSalvar, botaoAbrir);
        hBox.setPadding(new Insets(10));
        VBox vBox = new VBox(hBox, campoTexto);
        
        Scene cena = new Scene(vBox, 600, 400);
        cena.getStylesheets().add("style.css");

        palco.setScene(cena);
        palco.setTitle("Editor de Texto");
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
PARA COMPILAR LOCALMENTE UTILIZE: javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls EditorDeTexto.java
PARA RODAR LOCALMENTE UTILIZE: java --module-path "%PATH_TO_FX%" --add-modules javafx.controls EditorDeTexto

REQUISITOS: JDK22, JavaFX 22

Created By: @luismiguelcassoni INSTAGRAM, luis-miguel-cassoni-prof GITHUB
My Linkedin: https://www.linkedin.com/in/lu%C3%ADs-miguel-cassoni-0a217a397/
*/
