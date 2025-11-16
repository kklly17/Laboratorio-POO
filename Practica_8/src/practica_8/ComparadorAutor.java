
package practica_8;

import java.util.Comparator;
/**
 *
 * @author Dell
 */
public class ComparadorAutor implements Comparator<Libro1703> {
    @Override
    public int compare(Libro1703 l1, Libro1703 l2) {
        return l1.getAutor().compareToIgnoreCase(l2.getAutor());
    }
}
