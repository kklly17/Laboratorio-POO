
package service;

import gymposkc9822.model.ClienteCano;
import gymposkc9822.model.Pago9822;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

public class GeneradorReportesK{
    
    public void generarReporteClientesAsync(List<ClienteCano> listaClientes) {
        

        Thread hiloReporte = new Thread(() -> {
            
            try {
                System.out.println("Iniciando generacion de reporte en segundo plano...");
                Thread.sleep(2000); 

                String nombreArchivo = "Reporte_Clientes_" + System.currentTimeMillis() + ".txt";
                
                try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
                    escritor.println("=========================================");
                    escritor.println("       GYMPOS - REPORTE DE CLIENTES      ");
                    escritor.println("       Generado por: Admin Kelly Cano    ");
                    escritor.println("       Fecha: " + LocalDateTime.now());
                    escritor.println("=========================================");
                    escritor.println("");
                    
                    escritor.printf("%-10s %-20s %-20s %-15s%n", "ID", "NOMBRE", "PLAN", "ESTADO");
                    escritor.println("------------------------------------------------------------------");

                    for (ClienteCano c : listaClientes) {
                        String plan = (c.getMembresiaActiva() != null) ? c.getMembresiaActiva().getNombreMembresia() : "SIN PLAN";
                        escritor.printf("%-10s %-20s %-20s %-15s%n", 
                                c.getId(), 
                                c.getNombre() + " " + c.getApellido(), 
                                plan,
                                "ACTIVO");
                    }
                    
                    escritor.println("");
                    escritor.println("Total de clientes registrados: " + listaClientes.size());
                    escritor.println("=========================================");
                }
                Platform.runLater(() -> {
                    mostrarAlerta("Reporte Generado", "El archivo '" + nombreArchivo + "' se creo exitosamente.");
                });

            } catch (Exception e) {
                Platform.runLater(() -> mostrarError("Error en reporte", e.getMessage()));
            }
        });

        hiloReporte.start();
    }
    
    public void generarReportePagosAsync(List<Pago9822> listaPagos) {
         Thread hilo = new Thread(() -> {
             try {
                 Thread.sleep(1500); // Simular carga
                 String nombreArchivo = "Reporte_Financiero_" + System.currentTimeMillis() + ".txt";
                 
                 try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
                     pw.println("--- REPORTE FINANCIERO GYMPOS ---");
                     double total = 0;
                     for(Pago9822 p : listaPagos) {
                         pw.println("Ticket: " + p.getIdPago() + " | Monto: $" + p.getMonto());
                         total += p.getMonto();
                     }
                     pw.println("---------------------------------");
                     pw.println("TOTAL INGRESOS: $" + total);
                 }
                 
                 Platform.runLater(() -> mostrarAlerta("Reporte Financiero", "Guardado en: " + nombreArchivo));
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
         });
         hilo.start();
    }
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    
    private void mostrarError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
