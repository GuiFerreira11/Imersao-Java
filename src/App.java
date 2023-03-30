import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
  public static void main(String[] args) throws Exception {

    // API api = API.IMDB_TOP_MOVIES;
    API api = API.NASA_APOD;

    String url = api.getUrl();
    ExtratorConteudo extrator = api.getExtrator();

    var http = new ClienteHttp();
    String dados = http.buscaDados(url);

    List<Conteudo> conteudos = extrator.extraiConteudo(dados);

    var geradora = new GeradoraDeFigurinhas();

    var diretorio = new File("figurinhas/");
    diretorio.mkdir();

    for (int i = 0; i < 3; i++) {

      Conteudo conteudo = conteudos.get(i);

      String titulo = conteudo.titulo();
      String urlImagem = conteudo.urlImagem();

      // float classificacao = Float.parseFloat(imdbrating);
      // int totalEstrelas = Math.round(classificacao);

      InputStream inputStream = new URL(urlImagem).openStream();
      String nomeArquivo = "figurinhas/" + titulo + ".png";

      geradora.cria(inputStream, nomeArquivo);

      System.out.println("\u001b[1mTitulo: \u001b[m" + titulo);
      // System.out.print("\u001b[1mAvaliação: \u001b[m");
      // for (int estrela = 1; estrela <= totalEstrelas; estrela++) {
      // System.out.print("⭐");
      // }
      // System.out.println("\n");
      System.out.println();

    }
  }
}
