
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LerCredenciais {
    public String retornaUsuario() {
        Path caminho = Paths.get("userdata/user.txt");
        try {
            String usuario = Files.readString(caminho);
            return usuario;
        } catch (IOException e) {
            System.out.println("Erro ao ler entrada de usuário: " + e.getMessage());
            return null;
        }
    }

    public String retornaSenha() {
        Path caminho = Paths.get("userdata/password.txt");
        try {
            String senha = Files.readString(caminho);
            return senha;
        } catch (IOException e) {
            System.out.println("Erro ao ler entrada de senha: " + e.getMessage());
            return null;
        }
    }
}
