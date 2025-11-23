package gymposkc9822.model;

import java.io.Serializable;

public class Empleado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String idUsuario; 
    private String password;
    private String nombreCompleto;
    private String rol; 

    public Empleado(String idUsuario, String password, String nombreCompleto, String rol) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
    }
    public String getIdUsuario() { return idUsuario; }
    public String getPassword() { return password; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getRol() { return rol; }
}