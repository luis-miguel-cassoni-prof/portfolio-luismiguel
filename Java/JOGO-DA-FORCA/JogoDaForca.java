import java.util.Random;

public class JogoDaForca {
    private final String[] PALAVRAS = new String[]{"bola", "roupa", "garrafa", "jogo", "cobra", "rato", "passaro", "gaita", "passarela",
        "gaiola", "baralho", "professor", "jogador", "desenvolvedor", "cachorro", "galinha"
    };

    public String escolherPalavra() {
        Random escolha = new Random();
        int indice = escolha.nextInt(PALAVRAS.length);
        return PALAVRAS[indice];
    }
}
