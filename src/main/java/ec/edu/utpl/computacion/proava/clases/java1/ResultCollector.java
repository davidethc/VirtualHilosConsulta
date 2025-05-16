package ec.edu.utpl.computacion.proava.clases.java1;

import java.util.*;

public class ResultCollector {
    // Enviamos el resultado al recolector compartido
    private static final List<String> results = new ArrayList<>();

    // Método sincronizado para evitar conflictos entre hilos
    public static synchronized void add(String result) {
        results.add(result);
    }
    // Devuelve la lista de resultados
    public static List<String> getResults() {
        return results;
    }
}
