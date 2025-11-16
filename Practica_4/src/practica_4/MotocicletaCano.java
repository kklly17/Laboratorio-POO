package practica_4;

public class MotocicletaCano extends VehiculoK {

    public MotocicletaCano(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public String encender() {
        return "\nLa motocicleta ruge al encender.";
    }

    @Override
    public String acelerar() {
        return "\nLa moto acelera rápidamente.";
    }

    @Override
    public String frenar() {
        return "\nLa moto usa freno de disco.";
    }
}

