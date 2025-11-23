
package service;

import gymposkc9822.model.ClienteCano;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlAccesoCano {

    public static class ResultadoAcceso {
        public boolean permitido;
        public String mensaje;
        public String estiloColor; 

        public ResultadoAcceso(boolean permitido, String mensaje, String estiloColor) {
            this.permitido = permitido;
            this.mensaje = mensaje;
            this.estiloColor = estiloColor;
        }
    }

    public ResultadoAcceso validarEntrada(ClienteCano cliente) {
 
        if (cliente == null) {
            return new ResultadoAcceso(false, "ID NO ENCONTRADO", "rojo");
        }

        if (cliente.getMembresiaActiva() == null) {
            return new ResultadoAcceso(false, "SIN MEMBRESÍA ACTIVA", "rojo");
        }

        LocalDate fechaInicio = cliente.getFechaRegistro();
        int diasDuracion = cliente.getMembresiaActiva().getDuracionDias();
        
        LocalDate fechaVencimiento = fechaInicio.plusDays(diasDuracion);
        LocalDate hoy = LocalDate.now();

        if (hoy.isAfter(fechaVencimiento)) {
            long diasVencido = ChronoUnit.DAYS.between(fechaVencimiento, hoy);
            return new ResultadoAcceso(false, "MEMBRESÍA VENCIDA hace " + diasVencido + " días.", "rojo");
        } else {
            long diasRestantes = ChronoUnit.DAYS.between(hoy, fechaVencimiento);
            
            if (diasRestantes <= 5) {
                return new ResultadoAcceso(true, "ACCESO CONCEDIDO\n(Vence en " + diasRestantes + " días)", "amarillo");
            } else {
                return new ResultadoAcceso(true, "¡BIENVENIDO!", "verde");
            }
        }
    }
}