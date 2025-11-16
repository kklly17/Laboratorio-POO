
package practica_4;

public class VehiculoK {
    
    private String marca;
    private String modelo;
    private double precio;
    
    public VehiculoK(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

 
    public String getMarca() {
        return marca; 
    }
    
    public String getModelo() {
        return modelo; 
    }

    public double getPrecio() {
        return precio; 
    }

    public String encender() {
        return "El vehiculo esta encendido.";
    }
    
    public String acelerar() {
        return "El vehiculo esta acelerando.";
    }
    
    public String frenar() {
        return "El vehiculo esta frenando.";
    }
    
    @Override
    public String toString() {
        return marca + " " + modelo + " " + "$" + precio;
    }
}
