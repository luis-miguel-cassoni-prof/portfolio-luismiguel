
import org.json.JSONObject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ProjetoClimatico projetoClimatico = new ProjetoClimatico();

        try {
            System.out.println("Digite o nome da cidade: ");
            String cidade = input.nextLine();

            String dadosClimaticos = projetoClimatico.getDadosClimaticos(cidade);

            if(dadosClimaticos.contains("\"code\":1006")) {
                System.out.println("Localização não encontrada. Por favor, tente novamente.");
            } else {
                projetoClimatico.exibirDadosClimaticos(dadosClimaticos);
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        input.close();
    }
}
