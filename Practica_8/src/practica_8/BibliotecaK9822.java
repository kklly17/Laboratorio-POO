
package practica_8;

import java.util.*;
/**
 *
 * @author Dell
 */
public class BibliotecaK9822 {

    private ArrayList<Libro1703> libros = new ArrayList<>();
    private LinkedList<Libro1703> colaReservas = new LinkedList<>();
    private HashMap<String, String> usuarios = new HashMap<>();
    private HashSet<String> categorias = new HashSet<>();

    //crud

    public void agregarLibro(Libro1703 libro) {
        long inicio = System.nanoTime();
        libros.add(libro);
        categorias.add(libro.getCategoria());
        long fin = System.nanoTime();
        System.out.println("Tiempo agregar: " + (fin - inicio) + " ns");
    }

    public void eliminarLibro(String titulo) {
        long inicio = System.nanoTime();
        libros.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
        long fin = System.nanoTime();
        System.out.println("Tiempo eliminar: " + (fin - inicio) + " ns");
    }

    public void actualizarLibro(String titulo, Libro1703 nuevoLibro) {
        long inicio = System.nanoTime();
        ListIterator<Libro1703> it = libros.listIterator();
        while (it.hasNext()) {
            if (it.next().getTitulo().equalsIgnoreCase(titulo)) {
                it.set(nuevoLibro);
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo actualizar: " + (fin - inicio) + " ns");
    }

    public void mostrarLibros() {
        libros.forEach(System.out::println);
    }
    
    public void ordenarPorAnio() {
        libros.sort(new ComparadorAnio());
    }

    public void ordenarPorAutor() {
        libros.sort(new ComparadorAutor());
    }

    public void reservarPorTitulo(String titulo) {
             libros.stream()
            .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
            .findFirst()
            .ifPresent(this::reservarLibro);
    }


    //streams

    public void buscarPorCategoria(String categoria) {
        System.out.println("Resultado de la busqueda:");
        libros.stream()
                .filter(l -> l.getCategoria().equalsIgnoreCase(categoria))
                .forEach(System.out::println);
    }

    // manejo de iteradores

    public void mostrarConIterador() {
        Iterator<Libro1703> it = libros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public void agregarUsuario(String matricula, String nombre) {
        usuarios.put(matricula, nombre);
    }

    public void reservarLibro(Libro1703 libro) {
        colaReservas.add(libro);
    }

    public void atenderReserva() {
        if (!colaReservas.isEmpty()) {
            System.out.println("Atendiendo reserva: " + colaReservas.poll());
        }
    }
}

    
