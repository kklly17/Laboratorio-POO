
package practica_4;

public class Practica_4 {

    public static void main(String[] args) {
        
        VehiculoK v1 = new AutoCano("Nissan", "Versa", 250000);
        VehiculoK v2 = new MotocicletaCano("Yamaha", "R3", 160000);
        VehiculoK v3 = new CamionCano("Volvo", "FH16", 800000);

        Concesionaria9822 consecionariaCano = new Concesionaria9822();

        consecionariaCano.agregarVehiculo(v1);
        consecionariaCano.agregarVehiculo(v2);
        consecionariaCano.agregarVehiculo(v3);
       
        consecionariaCano.mostrarVehiculos();

        System.out.println("\nPRUEBA DE POLIMORFISMO");
        System.out.println("-------------------------------------------");
        System.out.println(v1.encender());
        System.out.println(v2.encender());
        System.out.println(v3.encender());
    }
}
  
