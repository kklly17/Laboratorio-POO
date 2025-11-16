
package Test;

import practica_7.SistemaBancoKC;
import practica_7.TryWithResources;
/**
 *
 * @author Dell
 */
public class TestExcepciones {
   
    public static void main(String[] args) {

        SistemaBancoKC sistema = new SistemaBancoKC();
        TryWithResources archivo = new TryWithResources();

        System.out.println("\n--- PRUEBA 1: Matricula incorrecta ---");
        sistema.operar("1111", "kcano", 100);

        System.out.println("\n--- PRUEBA 2: Usuario incorrecto ---");
        sistema.operar("9822", "usuarioX", 100);

        System.out.println("\n--- PRUEBA 3: Saldo insuficiente ---");
        sistema.operar("9822", "kcano", 5000);

        System.out.println("\n--- PRUEBA 4: Operacion correcta ---");
        sistema.operar("9822", "kcano", 200);

        System.out.println("\n--- PRUEBA 5: try-with-resources ---");
        archivo.leerArchivo();

        System.out.println("\nPruebas completadas. Revisar archivo log:");
        System.out.println("log_KC_9822.txt");
    }
}

