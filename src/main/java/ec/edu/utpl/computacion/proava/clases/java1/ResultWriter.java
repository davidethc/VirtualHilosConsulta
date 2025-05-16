package ec.edu.utpl.computacion.proava.clases.java1;

import java.io.*;
import java.util.List;

public class ResultWriter {
    // Escribe cada resultado en el archivo de salida
    public static void writeToFile(String fileName, List<String> results) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        // Escribimos cada línea (resultado)
        for (String line : results) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
