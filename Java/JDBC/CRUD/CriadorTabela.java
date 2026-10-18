
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriadorTabela {
    public static void main(String[] args) {
        ConexaoDB conexao = new ConexaoDB();
        LerCredenciais reader = new LerCredenciais();

        try (Connection conexaoDB = conexao.conectar(reader.retornaUsuario(), reader.retornaSenha());
            Statement statement = conexaoDB.createStatement()
        ) {

            String comandoSQL = "CREATE TABLE IF NOT EXISTS produtos (" + 
                "id_produto INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(100) NOT NULL," +
                "quantidade INT NOT NULL," +
                "preco DECIMAL(10,2) NOT NULL," +
                "status ENUM('Disponivel', 'Indisponivel') NOT NULL" +
                ") DEFAULT CHARSET = 'utf8mb4';";

            System.out.println(comandoSQL);

            statement.execute(comandoSQL);

            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
/*
javac -cp "lib/mysql-connector-j-9.4.0.jar;." *.java
java -cp "lib/mysql-connector-j-9.4.0.jar;." CriadorTabela.java
*/
