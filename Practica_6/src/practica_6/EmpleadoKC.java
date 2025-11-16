
package practica_6;


public abstract class EmpleadoKC {
    
    protected String nombre;
    protected double salarioBase;

    public EmpleadoKC(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    
    public String getInformacion() {
        return "Nombre: " + nombre + ", Salario: $ " + salarioBase;
    }
    
     // Metodos abstractos
    public abstract double calcularSalarioTotal();
    public abstract String getPuesto();
}

