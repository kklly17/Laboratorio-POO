
package practica_9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorArchivosCano9822 {

    private static final String ARCHIVO_TEXTO = "datos_1979822.txt";
    private static final String ARCHIVO_SERIALIZADO = "backup_1703.dat";
    private static final String ARCHIVO_CSV = "log_Cano.csv";
    private static final String DIRECTORIO_BACKUP = "backups_practica";

    
    public void escribirArchivoTexto(String contenido) {
        // Usamos try-with-resources para que el archivo se cierre solo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_TEXTO))) {
            writer.write(contenido);
            System.out.println("Archivo de texto '" + ARCHIVO_TEXTO + "' escrito.");
            escribirCSV("ESCRITURA_TEXTO", contenido.length() + " bytes"); // Punto 3
        } catch (IOException e) {
            System.err.println("Error al escribir archivo de texto: " + e.getMessage());
        }
    }

    public void leerArchivoTexto() {
        System.out.println("--- Leyendo '" + ARCHIVO_TEXTO + "' ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_TEXTO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            escribirCSV("LECTURA_TEXTO", "OK"); // Punto 3
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + ARCHIVO_TEXTO);
        } catch (IOException e) {
            System.err.println("Error al leer archivo de texto: " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }
    
    public void guardarObjeto(PersonaKSerializable persona) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_SERIALIZADO))) {
            oos.writeObject(persona);
            System.out.println("Objeto guardado en '" + ARCHIVO_SERIALIZADO + "': " + persona);
            escribirCSV("SERIALIZAR_OBJETO", persona.toString()); // Punto 3
        } catch (IOException e) {
            System.err.println("Error al serializar objeto: " + e.getMessage());
        }
    }

    public void cargarObjeto() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_SERIALIZADO))) {
            PersonaKSerializable persona = (PersonaKSerializable) ois.readObject();
            System.out.println("Objeto cargado desde '" + ARCHIVO_SERIALIZADO + "': " + persona);
            escribirCSV("DESERIALIZAR_OBJETO", persona.toString()); // Punto 3
        } catch (FileNotFoundException e) {
            System.err.println("Archivo serializado no encontrado: " + ARCHIVO_SERIALIZADO);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar objeto: " + e.getMessage());
        }
    }
    
    public void escribirCSV(String accion, String detalle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CSV, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            writer.write("K,1979822," + accion + "," + detalle + "," + timestamp + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en CSV: " + e.getMessage());
        }
    }
    
    public void crearBackupTexto() {
        File dir = new File(DIRECTORIO_BACKUP);
        if (!dir.exists()) {
            dir.mkdir(); 
            System.out.println("Directorio de backup creado: " + DIRECTORIO_BACKUP);
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String nombreBackup = "datos_1979822_" + timestamp + ".txt";
        
        try {
            Files.copy(Paths.get(ARCHIVO_TEXTO), 
                       Paths.get(DIRECTORIO_BACKUP, nombreBackup), 
                       StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup creado con exito ");
            escribirCSV("BACKUP_CREADO", nombreBackup); 
        } catch (FileNotFoundException e) {
            System.err.println("No se puede crear backup. Archivo original no existe: " + ARCHIVO_TEXTO);
        } catch (IOException e) {
            System.err.println("Error al crear backup: " + e.getMessage());
        }
    }
}