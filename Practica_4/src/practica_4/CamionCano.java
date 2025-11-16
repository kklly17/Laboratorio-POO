package practica_4;


public class CamionCano extends VehiculoK {

    public CamionCano(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public String encender() {
        return "\nEl camion enciende con fuerza.";
    }

    @Override
    public String acelerar() {
        return "\nEl camión acelera lentamente debido a su carga.";
    }

    @Override
    public String frenar() {
        return "\nEl camión usa frenos neumaticos.";
    }
}

