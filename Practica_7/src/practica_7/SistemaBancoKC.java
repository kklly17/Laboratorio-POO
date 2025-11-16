
package practica_7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SistemaBancoKC {

    private double saldo = 1000;
    private String matriculaCorrecta = "9822";

    private void escribirLog(String mensaje) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("log_KC_9822.txt", true))) {
            pw.println(mensaje);
        } catch (IOException e) {
            System.out.println("Error escribiendo el log.");
        }
    }

    public void validarMatricula(String matricula) throws Matricula17InvalidaException {
        if (!matricula.equals(matriculaCorrecta)) {
            throw new Matricula17InvalidaException("La matricula no coincide con la del sistema.");
        }
    }

    public void retirar(double cantidad) throws Saldo03InsuficienteException {
        if (cantidad > saldo) {
            throw new Saldo03InsuficienteException("Saldo insuficiente para retirar " + cantidad);
        }
        saldo -= cantidad;
    }

    public void buscarUsuario(String user) throws Usuario9822NoEncontradoException {
        if (!user.equals("kcano")) {
            throw new Usuario9822NoEncontradoException("Usuario '" + user + "' no encontrado.");
        }
    }

    public void operar(String matricula, String usuario, double retiro) {
        try {
            validarMatricula(matricula);
            buscarUsuario(usuario);
            retirar(retiro);
            System.out.println("Operacion completada exitosamente.");

        } catch (Matricula17InvalidaException | Usuario9822NoEncontradoException | Saldo03InsuficienteException e) {
            System.out.println("[!] Error: " + e.getMessage());
            escribirLog("[!] ERROR: " + e.getMessage());
        }
    }
}

