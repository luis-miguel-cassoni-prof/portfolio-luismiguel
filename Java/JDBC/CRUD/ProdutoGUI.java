import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProdutoGUI extends Application {
    private ProdutoDAO produtoDAO;
    private ObservableList<Produto> produtos;
    private TableView<Produto> tableView;
    private TextField nomeInput, quantidadeInput, precoInput;
    private ComboBox<String> statusComboBox;
    private ConexaoDB conexao = new ConexaoDB();
    private LerCredenciais credenciais = new LerCredenciais();
    private Connection conexaoDB;

    @Override 
    public void start(Stage palco) {
        conexaoDB = conexao.conectar(credenciais.retornaUsuario(), credenciais.retornaSenha());
        produtoDAO = new ProdutoDAO(conexaoDB);
        produtos = FXCollections.observableArrayList(produtoDAO.listarTodos());

        palco.setTitle("Gerenciamento de Estoque de Produtos");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(10);

        HBox nomeProdutoBox = new HBox();
        nomeProdutoBox.setSpacing(10);
        Label nomeLabel = new Label("Produto:");
        nomeInput = new TextField();
        nomeProdutoBox.getChildren().addAll(nomeLabel, nomeInput);

        HBox quantidadeBox = new HBox();
        quantidadeBox.setSpacing(10);
        Label quantidadeLabel = new Label("Quantidade:");
        quantidadeInput = new TextField();
        quantidadeBox.getChildren().addAll(quantidadeLabel, quantidadeInput);

        HBox precoBox = new HBox();
        precoBox.setSpacing(10);
        Label precoLabel = new Label("Preço:");
        precoInput = new TextField();
        precoBox.getChildren().addAll(precoLabel, precoInput);

        HBox statusBox = new HBox();
        statusBox.setSpacing(10);
        Label statusLabel = new Label("Status: ");
        statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Disponivel", "Indisponivel");
        statusBox.getChildren().addAll(statusLabel, statusComboBox);

        Button addButton = new Button("Adicionar");
        addButton.setOnAction(e -> {
            Produto produto = new Produto(nomeInput.getText(), Integer.parseInt(quantidadeInput.getText()), new BigDecimal(precoInput.getText().replace(',', '.'))
            , statusComboBox.getValue());

            produtoDAO.inserir(produto);
            produtos.setAll(produtoDAO.listarTodos());
            
            nomeInput.clear();
            quantidadeInput.clear();
            precoInput.clear();
            statusComboBox.getSelectionModel().clearSelection();
        });

        Button updateButton = new Button("Atualizar");
        updateButton.setOnAction(e -> {
            Produto selecionarProduto = tableView.getSelectionModel().getSelectedItem();
            if (selecionarProduto != null) {
                selecionarProduto.setNome(nomeInput.getText());
                selecionarProduto.setQuantidade(Integer.parseInt(quantidadeInput.getText()));
                selecionarProduto.setPreco(new BigDecimal(precoInput.getText().replace(',', '.')));
                selecionarProduto.setStatus(statusComboBox.getValue());
                produtoDAO.atualizar(selecionarProduto);
                produtos.setAll(produtoDAO.listarTodos());

                nomeInput.clear();
                quantidadeInput.clear();
                precoInput.clear();
                statusComboBox.getSelectionModel().clearSelection();
            }
        });

        Button deleteButton = new Button("Excluir");
        deleteButton.setOnAction(e -> {
            Produto selecionarProduto = tableView.getSelectionModel().getSelectedItem();
            if (selecionarProduto != null) {
                produtoDAO.excluirPorId(selecionarProduto.getId());
                produtos.setAll(produtoDAO.listarTodos());

                nomeInput.clear();
                quantidadeInput.clear();
                precoInput.clear();
                statusComboBox.getSelectionModel().clearSelection();
            }
        });

        Button clearButton = new Button("Limpar");
        clearButton.setOnAction(e -> {
            nomeInput.clear();
            quantidadeInput.clear();
            precoInput.clear();
            statusComboBox.getSelectionModel().clearSelection();
        });

        tableView = new TableView<>();
        tableView.setItems(produtos);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        List<TableColumn<Produto, ?>> columns = List.of(
            criarColuna("ID", "id"),
            criarColuna("Produto", "nome"),
            criarColuna("Quantidade", "quantidade"),
            criarColuna("Preço", "preco"),
            criarColuna("Status", "status")
        );
        tableView.getColumns().addAll(columns);

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nomeInput.setText(newSelection.getNome());
                quantidadeInput.setText(String.valueOf(newSelection.getQuantidade()));
                precoInput.setText(String.valueOf(newSelection.getPreco()));
                statusComboBox.setValue(newSelection.getStatus());
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(addButton, updateButton, deleteButton, clearButton);

        vBox.getChildren().addAll(nomeProdutoBox, quantidadeBox, precoBox, statusBox, buttonBox, tableView);

        Scene cena = new Scene(vBox, 800, 600);
        palco.setScene(cena);
        palco.show();
        
    }

    @Override
    public void stop() {
        try {
            conexaoDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private TableColumn<Produto, String> criarColuna(String title, String property) {
        TableColumn<Produto, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        return col;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
