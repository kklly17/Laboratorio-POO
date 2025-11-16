package practica_9;

import java.io.Serializable;
/**
 *
 * @author Dell
 */
public class PersonaKSerializable implements Serializable {

    private static final long serialVersionUID = 1L;
    
    String nombre;
    int edad;

    public PersonaKSerializable(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "PersonaKSerializable{nombre='" + nombre + "', edad=" + edad + "}";
    }
}
    

