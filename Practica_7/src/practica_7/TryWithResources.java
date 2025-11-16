
package practica_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public void leerArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("archivo_prueba.txt"))) {
            System.out.println("Contenido: " + br.readLine());
        }
        catch (IOException e) {
            System.out.println("Archivo no encontrado o error de lectura.");
        }
    }

}

