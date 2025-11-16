
package practica_6;

/**
 *
 * @author Dell
 */
public class GerenteCano extends EmpleadoKC implements Bonificable17, Evaluable03, Promovible9822 {

    public GerenteCano(String nombre) {
        super(nombre, 30000.0); 
    }
    
    @Override
    public double calcularSalarioTotal() {
        return salarioBase + calcularBono();
    }

     @Override
    public String getPuesto(){
        return "Gerente General";
    }
    
    @Override
    public double calcularBono() {
        return 3000.0; 
    }

    @Override
    public String evaluarDesempenio() {
        return "Desempeño Excelente (Gerente)";
    }

    @Override
    public boolean esPromovible() {
        return false; //Está en el puesto limite
    }
}

