
package banco_central;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuentaBancariaTest {   
    
   @Test
    public void testEncapsulamiento() {

        CuentaBancaria1703 cuenta = new CuentaBancaria1703("1234567", 3500.0 , "Juan Dominguez");
        
        assertEquals("1234567", cuenta.getCuenta());
        assertEquals(3500.0, cuenta.getSaldo(), 0.001);
        assertEquals("Juan Domiguez", cuenta.getTitular());

    }
    
   @Test
   public void testRelacionComposicion() {
        CuentaBancaria1703 cuenta = new CuentaBancaria1703("123456", 1000.0, "Ana García");
        
        ClienteCano cliente = new ClienteCano( "Ana García", "ana@email.com", cuenta);
        
        assertNotNull(cliente.getCuenta());
        assertEquals("123456", cliente.getCuenta().getCuenta());
    }
   
  

}
