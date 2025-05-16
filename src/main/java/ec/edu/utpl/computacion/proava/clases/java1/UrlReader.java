package ec.edu.utpl.computacion.proava.clases.java1;

import java.io.*;
import java.util.*;

public class UrlReader {
    // Lee las URLs desde un archivo y las devuelve en una lista
    public static List<String> readFromFile(String fileName) throws IOException {
        List<String> urls = new ArrayList<>();
        // Abrimos el archivo para leer línea por línea
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        // Agregamos cada línea (URL) a la lista
        while ((line = reader.readLine()) != null) {
            urls.add(line.trim());
        }
        reader.close();
        return urls;
    }
}
