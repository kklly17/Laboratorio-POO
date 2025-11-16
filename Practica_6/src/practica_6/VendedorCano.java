
package practica_6;

/**
 *
 * @author Dell
 */

public class VendedorCano extends EmpleadoKC implements Bonificable17, Promovible9822 {

    private double ventasMensuales;
    
    public VendedorCano(String nombre, double ventas) {
        super(nombre, 3000.0);
        this.ventasMensuales = ventas;
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase + calcularBono();
    }
    
     @Override
    public String getPuesto(){
        return "Vendedor";
    }
    
    @Override
    public double calcularBono() {
        // 10% de comisión sobre ventas
        return ventasMensuales * 0.10; 
    }

    @Override
    public boolean esPromovible() {
        return ventasMensuales > 20000;
    }
}
