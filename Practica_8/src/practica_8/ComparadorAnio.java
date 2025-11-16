
package practica_8;

import java.util.Comparator;
/**
 *
 * @author Dell
 */
public class ComparadorAnio implements Comparator<Libro1703>{
    @Override
    public int compare(Libro1703 l1, Libro1703 l2) {
        return Integer.compare(l1.getAnio(), l2.getAnio());
    }
}

  
