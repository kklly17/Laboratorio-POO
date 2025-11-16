
package practica_9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorArchivosCano9822 gestor = new GestorArchivosCano9822();

        PersonaKSerializable personaPrueba = new PersonaKSerializable("K-Estudiante", 22);

        int opcion = 0;
        while (opcion != 9) {
            System.out.println("\n--- MENU GESTOR DE ARCHIVOS (Cano9822) ---");
            System.out.println("1. Escribir en archivo de texto");
            System.out.println("2. Leer archivo de texto ");
            System.out.println("3. Guardar objeto ");
            System.out.println("4. Cargar objeto");
            System.out.println("5. Crear Backup del archivo ");
            System.out.println("9. Salir");
            System.out.print("Elige una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el contenido a guardar: ");
                    String contenido = scanner.nextLine();
                    gestor.escribirArchivoTexto(contenido);
                    break;
                case 2:
                    gestor.leerArchivoTexto();
                    break;
                case 3:
                    gestor.guardarObjeto(personaPrueba);
                    break;
                case 4:
                    gestor.cargarObjeto();
                    break;
                case 5:
                    gestor.crearBackupTexto();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    System.out.println("-> datos_1979822.txt");
                    System.out.println("-> backup_1703.dat");
                    System.out.println("-> log_Cano.csv");
                    System.out.println("-> Carpeta 'backups_practica/'");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}