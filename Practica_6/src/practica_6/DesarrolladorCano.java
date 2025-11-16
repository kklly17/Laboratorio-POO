
package practica_6;

/**
 *
 * @author Dell
 */
public class DesarrolladorCano extends EmpleadoKC implements Bonificable17, Evaluable03 {
    
    private int lineasCodigoPorDia;

    public DesarrolladorCano(String nombre, int lineasDeCodigo) {
        super(nombre, 5000.0);
        this.lineasCodigoPorDia = lineasDeCodigo;
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase + calcularBono();
    }
    
     @Override
    public String getPuesto(){
        return "Desarrollador";
    }

    @Override
    public double calcularBono() {
        // Bono basado en rendimiento
        return this.lineasCodigoPorDia * 1.5; 
    }

    @Override
    public String evaluarDesempenio() {
        if (lineasCodigoPorDia > 500) {
            return "Desempeño Bueno";
        }
        return "Desempeño Regular";
    }
}

