
package practica_8;

/**
 *
 * @author Dell
 */
public class Libro1703 implements Comparable<Libro1703> {

    private String titulo;
    private String autor;
    private int anio;
    private String categoria;

    public Libro1703(String titulo, String autor, int anio, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
    }

    public String getTitulo() { 
        return titulo; 
    }
    
    public String getAutor() {
        return autor; 
    }
    public int getAnio() { 
        return anio; 
    }
    
    public String getCategoria() { 
        return categoria; 
    }

    @Override
    public int compareTo(Libro1703 o) {
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public String toString() {
        return titulo + " | " + autor + " | " + anio + " | " + categoria;
    }
}

