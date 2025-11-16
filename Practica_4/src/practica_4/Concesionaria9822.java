
package practica_4;

import java.util.ArrayList;

public class Concesionaria9822 {

    private ArrayList<VehiculoK> vehiculos;

    public Concesionaria9822() {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(VehiculoK v) {
        vehiculos.add(v);
    }

    public void mostrarVehiculos() {
        for (VehiculoK v : vehiculos) {
            System.out.println(v);
        }
    }

    public VehiculoK obtenerVehiculo(int index) {
        if (index >= 0 && index < vehiculos.size()) {
            return vehiculos.get(index);
        }
        return null;
    }

    public void eliminarVehiculo(int index) {
        if (index >= 0 && index < vehiculos.size()) {
            vehiculos.remove(index);
        }
    }

    public int cantidadVehiculos() {
        return vehiculos.size();
    }
}

