package gymposkc9822.model;

import java.io.Serializable;

public class Membresias0317 implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombreMembresia;
    private double costo;
    private int duracionDias;

    public Membresias0317() {}

    public Membresias0317(String nombreMembresia, double costo, int duracionDias) {
        this.nombreMembresia = nombreMembresia;
        this.costo = costo;
        this.duracionDias = duracionDias;
    }

    public String getNombreMembresia() { return nombreMembresia; }
    public void setNombreMembresia(String nombreMembresia) { this.nombreMembresia = nombreMembresia; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    public int getDuracionDias() { return duracionDias; }
    public void setDuracionDias(int duracionDias) { this.duracionDias = duracionDias; }

    @Override
    public String toString() {
        return nombreMembresia + " ($" + costo + ")";
    }
}


