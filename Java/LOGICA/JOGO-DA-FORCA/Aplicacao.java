
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JogoDaForca jogo = new JogoDaForca();

        String palavra = jogo.escolherPalavra();
        ArrayList<Character> letrasDescobertas = new ArrayList<>();

        for(int i = 0; i < palavra.length(); i++) {
            letrasDescobertas.add('_');
        }

        boolean palavraDescoberta = false;
        int tentativas = 6;

        while(!palavraDescoberta && tentativas > 0) {
            System.out.println();
            System.out.println("Palavra: " + letrasDescobertas);
            System.out.println("Você tem " + tentativas + " tentativas!");
            System.out.println("Digite uma Letra: ");
            char chute = input.next().charAt(0);
            boolean acertou = false;

            for(int i = 0; i < palavra.length(); i++) {
                if(palavra.charAt(i) == chute) {
                    letrasDescobertas.set(i, chute);
                    acertou = true;
                }
            }

            if(!acertou) {
                System.out.println("Você errou!");
                tentativas--;
            } else {
                System.out.println("Você acertou!");
            }

            if(!letrasDescobertas.contains('_')) {
                palavraDescoberta = true;
                break;
            }
        }

        if(palavraDescoberta) {
            System.out.println("Você escapou da forca! A palavra era: " + palavra);
        } else {
            System.out.println("Você perdeu e foi enforcado! A palavra era: " + palavra);
        }

        input.close();
    }
}

/*
PARA COMPILAR LOCALMENTE UTILIZE: javac Aplicacao.java
PARA RODAR LOCALMENTE UTILIZE: java Aplicacao

REQUISITOS: JDK22

Created By: @luismiguelcassoni INSTAGRAM, luis-miguel-cassoni-prof GITHUB
My Linkedin: https://www.linkedin.com/in/lu%C3%ADs-miguel-cassoni-0a217a397/
*/
