
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private final String URL_PADRAO = "jdbc:mysql://localhost:3306/jdbc";


    public Connection conectar(String usuario, String senha) {
        try {
            return DriverManager.getConnection(URL_PADRAO, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Falha em conectar com BD: " + e.getMessage());
            return null;
        }
    }
}
