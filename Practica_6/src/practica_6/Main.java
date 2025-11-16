
package practica_6;

public class Main {

  
    public static void main(String[] args) {
        
        System.out.println("\tBienvenido al sistema de EmpresaTIK9822");
        System.out.println("---------------------------------------------------\n");
        
        EmpresaTIK9822 miEmpresa = new EmpresaTIK9822();
        
        
        GerenteCano gerente = new GerenteCano("Kelly Cano");
        DesarrolladorCano dev = new DesarrolladorCano("Laura Jimenez", 600);
        VendedorCano vendedor = new VendedorCano("Julio Zepeda", 25000);
        
 
        miEmpresa.contratarEmpleado(gerente);
        miEmpresa.contratarEmpleado(dev);
        miEmpresa.contratarEmpleado(vendedor);
        
     
        miEmpresa.pagarNomina();
        miEmpresa.revisarPromociones();
        
       
        System.out.println("\n--- EVALUACIONES INDIVIDUALES ---");
        
       
        Evaluable03 evaluacionGerente = gerente;
        System.out.println("Evaluacion de " + gerente.nombre + ": " + evaluacionGerente.evaluarDesempenio());
        
        Evaluable03 evaluacionDev = dev;
        System.out.println("Evaluacion de " + dev.nombre + ": " + evaluacionDev.evaluarDesempenio());
        
    }
}
        
