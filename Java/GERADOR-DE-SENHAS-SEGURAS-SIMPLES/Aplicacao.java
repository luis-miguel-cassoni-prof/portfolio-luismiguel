import gerador.Gerador;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Gerador gerador = new Gerador();

        try {
            System.out.println("Digite a quantidade de caracteres que a senha gerada deve ter (mínimo 8)");
            int quantidade = input.nextInt();
            
            if(quantidade < 8) {
                System.out.println("A quantidade é insuficiente");
                input.close();
                return;
            }

            String senha = gerador.gerarSenha(quantidade);
            System.out.println("A senha gerada foi: " + senha);
        } catch (InputMismatchException e) {
            System.out.println("Erro: O primitivo digitado não foi Inteiro");
        } catch (NullPointerException e) {
            System.out.println("Erro: O valor digitado não pode ser nulo");
        }

        input.close();
    }
}
