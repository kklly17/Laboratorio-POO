package holamundokc;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
        
public class HolaMundoKC
{
    
    public static void main(String[] args) 
    {
        
        String nombre = "Kelly Yisseth Cano Montiel";
        String matricula = "1979822";
        
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Nombre: "+nombre);
        System.out.println("Matricula: "+matricula);
        System.out.println("Fecha actual: " + fechaActual.format(formato));
    } 
}

