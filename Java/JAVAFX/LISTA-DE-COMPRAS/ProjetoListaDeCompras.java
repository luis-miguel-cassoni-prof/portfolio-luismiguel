import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProjetoListaDeCompras extends Application {
    private ArrayList<String> listaDeCompras = new ArrayList<>();
    private ListView<String> verLista = new ListView<>();

    @Override 
    public void start(Stage palco) {
        palco.setTitle("Aplicativo de Lista de Compras");

        TextField descricaoItem = new TextField();
        Button botaoAdicionar = new Button("Adicionar");
        Button exportar = new Button("Exportar Lista");

        Label labelAdicionar = new Label("Digite o item que deseja adicionar:");
        Label labelListaDeCompras = new Label("Lista de Compras:");

        // Criação do objeto ObservableList a partir da listaDeCompras
        ObservableList<String> observableListaDeCompras = FXCollections.observableArrayList();
        verLista.setItems(observableListaDeCompras);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(labelAdicionar, descricaoItem, botaoAdicionar);
        vBox.getChildren().addAll(labelListaDeCompras, verLista, exportar);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        botaoAdicionar.setOnAction(e -> {
            String item = descricaoItem.getText();

            if(!item.isEmpty()) {
                listaDeCompras.add(item);
                verLista.getItems().add(item);
                descricaoItem.clear();
            }
        });

        exportar.setOnAction(e -> {
            try {
                File arquivo = new File("listaDeCompras.txt");
                PrintWriter writer = new PrintWriter(arquivo);

                for(String item : listaDeCompras) {
                    writer.println(item);
                }
                writer.close();
            } catch (IOException err) {
                System.out.println("Erro na leitura do arquivo: " + err.getMessage());
            }
        });

        Scene cena = new Scene(vBox, 350, 300);
        
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
