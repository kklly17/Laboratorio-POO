
package practica_8;

import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class Main {

    public static void main(String[] args) {
      
        BibliotecaK9822 b = new BibliotecaK9822();
        Scanner sc = new Scanner(System.in);

        // --- Datos personalizados del estudiante ---
        b.agregarUsuario("9822", "Kelly Cano");

        // --- Libros de prueba ---
        b.agregarLibro(new Libro1703("Java Basico", "Perez", 2010, "Programacion"));
        b.agregarLibro(new Libro1703("POO Facil", "Lopez", 2015, "Programacion"));
        b.agregarLibro(new Libro1703(" Cien años de soledad", "Marquez", 1967, "Novela"));
        b.agregarLibro(new Libro1703(" Aventuras", "Juan castillo", 2009, "Ficcion"));

        int opcion;

        do {
            System.out.println("\n--- MENU BIBLIOTECA K9822 ---");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Buscar por categoria");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Ordenar por anio");
            System.out.println("5. Reservar libro");
            System.out.println("6. Atender reserva");
            System.out.println("0. Salir");
            System.out.println("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n");
                    b.mostrarLibros();
                    break;
                    
                case 2:
                    System.out.print("Categoria: ");
                    String c = sc.nextLine();
                    b.buscarPorCategoria(c);
                    break;
                    
                case 3:
                    System.out.print("Titulo a eliminar: ");
                    String t = sc.nextLine();
                    b.eliminarLibro(t);
                    break;
                    
                case 4:
                    b.ordenarPorAnio();
                    b.mostrarLibros();
                    break;
                    
                case 5:
                    System.out.print("Titulo a reservar: ");
                    String r = sc.nextLine();
                    b.reservarPorTitulo(r);
                    break;
                    
                case 6:
                    b.atenderReserva();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
    
