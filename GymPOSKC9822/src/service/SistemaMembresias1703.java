
package service;

import gymposkc9822.model.Membresias0317;
import java.util.ArrayList;
import java.util.List;

public class SistemaMembresias1703 {

    public List<Membresias0317> obtenerMembresiasDisponibles() {
        List<Membresias0317> planes = new ArrayList<>();

        planes.add(new Membresias0317("Visita Unica", 50.22, 1));
        planes.add(new Membresias0317("Semanal", 200.22, 7));
        planes.add(new Membresias0317("Mensualidad Básica", 450.22, 30));
        planes.add(new Membresias0317("Trimestral", 1200.22, 90));
        planes.add(new Membresias0317("Anualidad VIP", 4500.22, 365));
        
        return planes;
    }
    
    public double obtenerPrecio(Membresias0317 membresia) {
        if (membresia != null) {
            return membresia.getCosto();
        }
        return 0.0;
    }
}