import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
  public static void main(String[] args) throws Exception {

    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    URI endereco = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();

    var parser = new JsonParser();
    List<Map<String, String>> listaDeFilmes = parser.parse(body);

    for (Map<String, String> filme : listaDeFilmes) {

      String titulo = filme.get("title");
      String imdbrating = filme.get("imDbRating");
      String urlImagem = filme.get("image");

      float classificacao = Float.parseFloat(imdbrating);
      int totalEstrelas = Math.round(classificacao);

      System.out.println("\u001b[1mTitulo: \u001b[m" + titulo);
      System.out.println("\033[01m Poster: " + urlImagem);
      System.out.print("\u001b[1mAvaliação: \u001b[m");
      for (int estrela = 1; estrela <= totalEstrelas; estrela++) {
        System.out.print("⭐");
      }
      System.out.println("\n");
      System.out.println();

    }
  }
}
