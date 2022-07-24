import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class stickerGenerator {
    void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        //Leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/image.png"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMGEzN2VkMmUtMGM1Zi00Y2U1LTlkMDktMTlhMTdmYzZmZDlhXkEyXkFqcGdeQXVyODEyNjEwMDk@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //Cria uma nova imagem com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 80;
        BufferedImage imagemNova = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //Copiar a imagem original na nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) imagemNova.getGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);

        //Configurar Fonte
        var font = new Font(Font.SANS_SERIF,Font.BOLD,18);
        graphics.setColor(Color.yellow);
        graphics.setFont(font);

        //Escrever uma frase na nova imagem
        graphics.drawString("FODA", 2, novaAltura - 10);

        //Escrever a imagem nova em um arquivo
        ImageIO.write(imagemNova, "png", new File("saida/" + nomeArquivo));
    }
}