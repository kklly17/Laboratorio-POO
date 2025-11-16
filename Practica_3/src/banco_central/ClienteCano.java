
package banco_central;

public class ClienteCano {
    
    protected String nombre;
    protected String email;
    
    private CuentaBancaria1703 cuenta;
    
    public ClienteCano( String nombre, String email, CuentaBancaria1703 cuenta) {
        this.nombre = nombre;
        this.email = email;
        this.cuenta = cuenta;
    }
    
     public CuentaBancaria1703 getCuenta() {
        return cuenta;
    }
    
     public void setCuenta(CuentaBancaria1703 cuenta) {
        this.cuenta = cuenta;
    }
     
    public void mostrarInformacion() {
        System.out.println("INFORMACIÓN DEL CLIENTE");
        System.out.println("----------------------------------");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Email: " + email);
        if (cuenta != null){
            System.out.println("=== INFORMACIÓN DE LA CUENTA ===");
            System.out.println(cuenta.toString());
        }
        else{
            System.out.println("Este cliente no tiene una cuetna registrada");
        }
    }
  
}
   
