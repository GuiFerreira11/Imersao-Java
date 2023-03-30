import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {
  public List<Conteudo> extraiConteudo(String dados) {

    var parser = new JsonParser();
    List<Map<String, String>> listaAtributos = parser.parse(dados);

    return listaAtributos.stream()
        .map(atributo -> new Conteudo(atributo.get("title"), atributo.get("url")))
        .toList();

  }
}
