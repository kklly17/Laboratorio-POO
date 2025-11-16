package estudiantekc;

import java.util.Objects;

public class Universidad9822 
{
    
    private EstudianteKC[] estudiantes;
    private int contEstudiantes;
    
    public Universidad9822(int capacidad)
    {
        estudiantes = new EstudianteKC[capacidad];
        contEstudiantes = 0;
    }
    
    public void agregarEstudiante(EstudianteKC e)
    {
         if(contEstudiantes < estudiantes.length)
         {
             estudiantes[contEstudiantes] = e;
             contEstudiantes++;
         }
         else
         {
             System.out.println("Maximo de alumnos alcanzado.");
         }
    }
    
    public EstudianteKC buscarEstudiante(String matricula)
    {
        for(int i = 0; i < contEstudiantes; i++)
        {
            if(Objects.equals(estudiantes[i].getMatricula(), matricula)){
                return estudiantes[i];
            }
        }
        return null;
    }
    
    public void mostrarEstudiantes()
    {
        if(contEstudiantes == 0)
        {
            System.out.println("No hay alumnos inscritos");
        }
        else
        {
            System.out.println("\n**ALUMNOS INSCRITOS **");
            for(int i = 0; i < contEstudiantes; i++)
            {
                estudiantes[i].mostrarInformacion();
                System.out.println("------------------------------------------------");
            }
        }
    }
     
     
            
}
