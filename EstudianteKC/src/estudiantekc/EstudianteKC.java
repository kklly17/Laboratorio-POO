package estudiantekc;

public class EstudianteKC 
{
    
    private String nombre;
    private String matricula;
    private int edad;
    private String carrera;
    private int semestreActual;
    
    /* CONSTRUCTORES*/
    public EstudianteKC(){
   
    }
    
    public EstudianteKC(String nombre, String matricula) 
    {
        this.nombre = nombre;
        this.matricula = matricula;
    }
    
    public EstudianteKC(String nombre, String matricula, int edad, String carrera, int semestreActual) 
    {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = carrera;
        this.semestreActual = semestreActual;
    }
    
    /*METODOS*/
    public void mostrarInformacion() 
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Edad: " + this.edad);
        System.out.println("Carrera: " + this.carrera);
        System.out.println("Semestre: " + this.semestreActual);
    }
    
    public void cambiarCarrera(String nuevaCarrera) 
    { 
        System.out.println("El alumno:" + this.nombre + " ha cambiado de " + this.carrera + " a " + nuevaCarrera);
        this.carrera = nuevaCarrera;
    }
    
    public boolean candidatoGraduacion(int semestresTotales) 
    {
        return this.semestreActual >= semestresTotales;
    }
    
    public void avanzarSemestre() 
    {
        this.semestreActual++;
        System.out.println(this.nombre + " ha avanzado al semestre " + this.semestreActual);
    }
    
    public boolean mayorDeEdad()
    {
        return edad >= 18;
    }
    
    public String getMatricula() 
    {
        return matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setSemestreActual(int semestreActual) {
        this.semestreActual = semestreActual;
    }
    
    
}
