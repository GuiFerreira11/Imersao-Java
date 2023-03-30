import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {
  public List<Conteudo> extraiConteudo(String dados) {

    var parser = new JsonParser();
    List<Map<String, String>> listaAtributos = parser.parse(dados);

    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributo : listaAtributos) {
      String titulo = atributo.get("title");
      String urlImagem = atributo.get("url");
      var conteudo = new Conteudo(titulo, urlImagem);
      conteudos.add(conteudo);

    }
    return conteudos;
  }
}
