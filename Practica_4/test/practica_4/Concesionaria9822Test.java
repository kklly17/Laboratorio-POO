
package practica_4;


import org.junit.Test;
import static org.junit.Assert.*;

public class Concesionaria9822Test {

    @Test
    public void testAgregarVehiculo() {
        Concesionaria9822 c = new Concesionaria9822();
        c.agregarVehiculo(new AutoCano("Honda", "Civic", 280000));
        assertEquals(1, c.cantidadVehiculos());
    }

    @Test
    public void testEliminarVehiculo() {
        Concesionaria9822 c = new Concesionaria9822();
        c.agregarVehiculo(new MotocicletaCano("Yamaha", "R1", 350000));
        c.eliminarVehiculo(0);
        assertEquals(0, c.cantidadVehiculos());
    }
}

   
