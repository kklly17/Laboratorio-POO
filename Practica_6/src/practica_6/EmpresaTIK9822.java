
package practica_6;

/**
 *
 * @author Dell
 */

import java.util.ArrayList;

public class EmpresaTIK9822 {
    
    private ArrayList<EmpleadoKC> listaEmpleados;

    public EmpresaTIK9822() {
        this.listaEmpleados = new ArrayList<>();
    }
    
    public void contratarEmpleado(EmpleadoKC empleado) {
        listaEmpleados.add(empleado);
        System.out.println("Contratando a: " + empleado.getInformacion());
    }
    
    public void pagarNomina() {
        System.out.println("\n--- PAGANDO NoMINA ---");
        for (EmpleadoKC emp : listaEmpleados) {
            System.out.println("Pagando a " + emp.nombre + ": $" + emp.calcularSalarioTotal());
        }
    }
    
    public void revisarPromociones() {
        System.out.println("\n--- REVISANDO PROMOCIONES ---");
        for (EmpleadoKC emp : listaEmpleados) {
            if (emp instanceof Promovible9822) {
                Promovible9822 candidato = (Promovible9822) emp;
                if (candidato.esPromovible()) {
                    System.out.println(emp.nombre + " ES APTO para promocion.");
                } else {
                    System.out.println(emp.nombre + " NO es apto para promocion.");
                }
            }
        }
    }
}
    

