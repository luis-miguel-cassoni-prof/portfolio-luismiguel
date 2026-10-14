import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class ProjetoClimatico {
    public String getDadosClimaticos(String nomeCidade) throws Exception {
        String apiKey = Files.readString(Paths.get("api_key.txt")).trim();

        String formataNomeCidade = URLEncoder.encode(nomeCidade, StandardCharsets.UTF_8);

        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade;
        
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public void exibirDadosClimaticos(String dados) {
        System.out.println("Dados originais (JSON) obtidos no site metereológico" + dados);
        
        JSONObject dadosJson = new JSONObject(dados);
        JSONObject informacoesMetereologicas = dadosJson.getJSONObject("current");

        String cidade = dadosJson.getJSONObject("location").getString("name");
        String pais = dadosJson.getJSONObject("location").getString("country");
        String condicaoTempo = informacoesMetereologicas.getJSONObject("condition").getString("text");
        int umidade = informacoesMetereologicas.getInt("humidity");
        float velocidadeVento = informacoesMetereologicas.getFloat("wind_kph");
        float pressaoAtmosferica = informacoesMetereologicas.getFloat("pressure_mb");
        float sensacaoTermica = informacoesMetereologicas.getFloat("feelslike_c");
        float temperaturaAtual = informacoesMetereologicas.getFloat("temp_c");

        String dataHoraString = informacoesMetereologicas.getString("last_updated");

        System.out.println("Informações Metereológicas para " + cidade + ", " + pais);
        System.out.println("Data e Hora: " + dataHoraString);
        System.out.println("Temperatura Atual: " + temperaturaAtual + "°C");
        System.out.println("Sensação Térmica: " + sensacaoTermica + "°C");
        System.out.println("Condição do Tempo: " + condicaoTempo);
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Velocidade Vento: " + velocidadeVento + "km/h");
        System.out.println("Pressão Atmosférica: " + pressaoAtmosferica + "mb");
    }
}
