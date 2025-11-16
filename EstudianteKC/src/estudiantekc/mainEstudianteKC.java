package estudiantekc;

public class mainEstudianteKC 
{
    public static void main(String[] args) 
    {
        Universidad9822 universidad = new Universidad9822(50);
        
        EstudianteKC e1 = new EstudianteKC();
        EstudianteKC e2 = new EstudianteKC("Carlos Jimenez", "2195688");
        EstudianteKC e3 = new EstudianteKC("Karla Ramirez", "1962984");
        EstudianteKC e4 = new EstudianteKC("Leonardo Perez", "1979822", 19, "LCC", 3);
        EstudianteKC e5 = new EstudianteKC("Cecilia Vidal", "2152894", 18, "LCC", 2);
        EstudianteKC e6 = new EstudianteKC("Roberto Castillo", "1879422", 23, "LF", 10);
        
        universidad.agregarEstudiante(e1);
        universidad.agregarEstudiante(e2);
        universidad.agregarEstudiante(e3);
        universidad.agregarEstudiante(e4);
        universidad.agregarEstudiante(e5);
        universidad.agregarEstudiante(e6);
        
        
        e1.setNombre("Julia Herrera");
        e1.setMatricula("2158968");
        e1.setEdad(20);
     
        
        System.out.println("-- CAMBIO DE CARRERA");
        e5.cambiarCarrera("LMAD");
        
        System.out.println("-- Avanzar semestre");
        e4.avanzarSemestre();
        
        System.out.println("-- Buscando alumno: 1879422");
        EstudianteKC eBuscar = universidad.buscarEstudiante("1879422");
        eBuscar.mostrarInformacion();
        
        universidad.mostrarEstudiantes();
    
    }
}
