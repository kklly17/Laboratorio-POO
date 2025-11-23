
package gymposkc9822.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import service.GeneradorReportesK;
import service.GestionClientesCano;
import service.ProcesadorPagos9822;

import java.io.IOException;

public class MenuPrincipalController {

    @FXML private Button btnClientes;
    @FXML private Button btnAcceso;
    @FXML private Button btnPagos;
    @FXML private Button btnSalir;

    private void cambiarPantalla(String archivoFxml, String titulo, Button botonOrigen) {
        try {
          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gymposkc9822/view/" + archivoFxml));
            Parent root = loader.load();

            Stage stage = (Stage) botonOrigen.getScene().getWindow();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("GymPOS - " + titulo);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error de Navegación", "No se pudo cargar la pantalla: " + archivoFxml);
        }
    }

    @FXML
    private void irAClientes(ActionEvent event) {
        cambiarPantalla("Clientes.fxml", "Gestión de Clientes", btnClientes);
    }

    @FXML
    private void irAControlAcceso(ActionEvent event) {
        cambiarPantalla("acceso.fxml", "Checador de Entrada", btnAcceso);
    }

    @FXML
    private void irAPagos(ActionEvent event) {
        cambiarPantalla("pagos.fxml", "Caja", btnPagos);
    }    
    
    @FXML
    private void cerrarSesion(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void generarReporte(ActionEvent event) {
        GeneradorReportesK generador = new GeneradorReportesK();
        GestionClientesCano clientesData = new GestionClientesCano();
        
        generador.generarReporteClientesAsync(clientesData.obtenerTodos());
    }
    
    @FXML
    private void generarReporteFinanciero(ActionEvent event) {
        ProcesadorPagos9822 procesador = new ProcesadorPagos9822();

        GeneradorReportesK generador = new GeneradorReportesK();
        
        generador.generarReportePagosAsync(procesador.obtenerHistorial());
    }

    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
