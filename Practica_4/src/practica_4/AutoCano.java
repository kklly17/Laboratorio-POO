package practica_4;


public class AutoCano extends VehiculoK {

    public AutoCano(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public String encender() {
        return super.encender() + "  \nEl auto esta listo para el viaje.";
    }

    @Override
    public String acelerar() {
        return "\nEl auto acelera suavemente.";
    }

    @Override
    public String frenar() {
        return "\nEl auto frena usando ABS.";
    }
}
    

