import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    // BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));
    // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
    // InputStream inputStream = new URL(
    // "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();

    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    var fonte = new Font("Impact", Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    String texto = "TOPZERA";

    FontMetrics fontMetrics = graphics.getFontMetrics();
    Rectangle2D retanguloTexto = fontMetrics.getStringBounds(texto, graphics);

    int larguraTexto = (int) retanguloTexto.getWidth();
    int alturaTexto = (int) retanguloTexto.getHeight();

    int posicaoTextoX = (largura - larguraTexto) / 2;
    int posicaoTextoY = novaAltura - ((200 - alturaTexto) / 2);

    graphics.drawString(texto, posicaoTextoX, posicaoTextoY);

    ImageIO.write(novaImagem, "png", new File(nomeArquivo));

  }

}
