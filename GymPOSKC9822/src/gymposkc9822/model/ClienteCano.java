
package gymposkc9822.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ClienteCano implements Serializable{
   
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;
    private Membresias0317 membresiaActiva;
    private int puntosRecompensa;

    
    // Constructores
    public ClienteCano () {
        
    }
    
    public ClienteCano(String id, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
   
        this.fechaRegistro = LocalDate.now(); 
        this.puntosRecompensa = 0; 
        this.membresiaActiva = null; 
    }
    
    public ClienteCano(String id, String nombre, String apellido, String email,
                       String telefono, LocalDate fechaRegistro,
                       Membresias0317 membresiaActiva, int puntosRecompensa) {

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = (fechaRegistro != null) ? fechaRegistro : LocalDate.now();
        this.membresiaActiva = membresiaActiva;
        this.puntosRecompensa = puntosRecompensa;
    }

    //getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Membresias0317 getMembresiaActiva() {
        return membresiaActiva;
    }

    public void setMembresiaActiva(Membresias0317 membresiaActiva) {
        this.membresiaActiva = membresiaActiva;
    }

    public int getPuntosRecompensa() {
        return puntosRecompensa;
    }

    public void setPuntosRecompensa(int puntosRecompensa) {
        this.puntosRecompensa = puntosRecompensa;
    }

    // Metodos

    public void agregarPuntos(int puntos) {
        if (puntos > 0) {
            this.puntosRecompensa += puntos;
        }
    }

    

    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellido;
    }


}
