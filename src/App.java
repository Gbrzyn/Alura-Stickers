import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        
        String url = "https://api.mocki.io/v2/549a5d8b";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        // Exibir e manipular dados
        ExtratorConteudo extrator = new ExtratorConteudoIMDB();  
        stickerGenerator geradora = new stickerGenerator();
        
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        for (Conteudo conteudo : conteudos) {
            String nomeArquivo = conteudo.getTitulo().replace(":", "-")  + ".png";
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            geradora.cria(inputStream,  nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println("-----------------");
        }

    }
}
