package ec.edu.utpl.computacion.proava.clases.java1;


public class Main {
    public static void main(String[] args) throws Exception {

        // Leemos la lista de URLs desde el archivo urls.txt

        var urls = UrlReader.readFromFile("/Users/monky02/Desktop/HilosVirtuales/src/main/java/ec/edu/utpl/computacion/proava/clases/java1/urls.txt");
        // Por cada URL, creamos un hilo virtual que procesará la URL
        for (String url : urls) {
            Thread.ofVirtual().start(() -> {
                UrlProcessor.process(url);
            });
        }

        // Esperamos 5 segundos para que todos los hilos terminen (forma sencilla) usar join)
        Thread.sleep(5000);
        // Escribimos los resultados en el archivo resultados.txt
        ResultWriter.writeToFile("/Users/monky02/Desktop/HilosVirtuales/src/main/java/ec/edu/utpl/computacion/proava/clases/java1/resultados.txt", ResultCollector.getResults());

        System.out.println("Proceso completado.");
    }
}
