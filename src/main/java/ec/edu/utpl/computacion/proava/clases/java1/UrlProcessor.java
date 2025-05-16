package ec.edu.utpl.computacion.proava.clases.java1;

import java.io.*;
import java.net.*;
import java.util.regex.*;

public class UrlProcessor {
    // Este método se encarga de procesar una URL individual
    public static void process(String url) {
        try {
            // Abrimos la conexión a la URL
            URL website = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));

            // Leemos todo el contenido HTML de la página
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            // Convertimos el contenido a String
            String html = content.toString();
            // Obtenemos el dominio principal de la URL (ej: www.example.com)

            String domain = website.getHost();
            // Usamos una expresión regular para buscar enlaces (href="...")
            Pattern pattern = Pattern.compile("href=[\"'](https?://[^\"'#]+)[\"']", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(html);
            // Contamos cuántos enlaces contienen el mismo dominio (URLs internas)
            int count = 0;
            while (matcher.find()) {
                String foundUrl = matcher.group(1);
                if (foundUrl.contains(domain)) {
                    count++;
                }
            }
            // Enviamos el resultado al recolector compartido

            ResultCollector.add(url + " -> " + count + " enlaces internos");

        } catch (Exception e) {
            ResultCollector.add(url + " -> ERROR: " + e.getMessage());
        }
    }
}
