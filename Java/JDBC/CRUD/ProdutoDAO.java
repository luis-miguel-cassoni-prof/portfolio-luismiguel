
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final Connection CONEXAO_DB;

    public ProdutoDAO(Connection conexao) {
        this.CONEXAO_DB = conexao;
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos (nome, quantidade, preco, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pStatement = CONEXAO_DB.prepareStatement(sql)) {
            pStatement.setString(1, produto.getNome());
            pStatement.setInt(2, produto.getQuantidade());
            pStatement.setBigDecimal(3, produto.getPreco());
            pStatement.setString(4, produto.getStatus());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void excluirTodos() {
        String sql = "DELETE FROM produtos";

        try (PreparedStatement pStatement = CONEXAO_DB.prepareStatement(sql)) {
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar todos os proudtos: " + e.getMessage());
        }
    }

    public Produto consultarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";

        try (PreparedStatement pStatement = CONEXAO_DB.prepareStatement(sql)) {
            pStatement.setInt(1, id);

            try(ResultSet resultSet = pStatement.executeQuery()) {
                if(resultSet.next()) {
                    Produto produto = new Produto();
                    produto.setId(resultSet.getInt("id"));
                    produto.setNome(resultSet.getString("nome"));
                    produto.setQuantidade(resultSet.getInt("quantidade"));
                    produto.setPreco(resultSet.getBigDecimal("preco"));
                    produto.setStatus(resultSet.getString("status"));
                    return produto;
                } 
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto por id: " + e.getMessage());
        }
        return null;
    }

    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, quantidade = ?, preco = ?, status = ? WHERE id = ?";
        
        try (PreparedStatement pStatement = CONEXAO_DB.prepareStatement(sql)) {
            pStatement.setString(1, produto.getNome());
            pStatement.setInt(2, produto.getQuantidade());
            pStatement.setBigDecimal(3, produto.getPreco());
            pStatement.setString(4, produto.getStatus());
            pStatement.setInt(5, produto.getId());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    public void exlcuirPorId(int id) {
        String sql = "DELETE FROM produtos WHERE ID = ?";

        try (PreparedStatement pStatement = CONEXAO_DB.prepareStatement(sql)) {
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto por id: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (PreparedStatement pStatement = CONEXAO_DB.prepareStatement(sql);
        ResultSet resultSet = pStatement.executeQuery()) {
            
            while(resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setPreco(resultSet.getBigDecimal("preco"));
                produto.setStatus(resultSet.getString("status"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os produtos: " + e.getMessage());
        }

        return produtos;
    }
}