package gymposkc9822.controller;

import service.ControlAccesoCano;
import service.ControlAccesoCano.ResultadoAcceso;
import service.GestionClientesCano;
import gymposkc9822.model.ClienteCano;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControlAccesoController {

    @FXML private TextField txtIdEntrada;
    @FXML private Label lblEstado;
    @FXML private Label lblMensaje;
    @FXML private Label lblClienteInfo;
    @FXML private VBox panelEstado;

    private GestionClientesCano gestorClientes;
    private ControlAccesoCano logicaAcceso;

    @FXML
    public void initialize() {
        gestorClientes = new GestionClientesCano();
        logicaAcceso = new ControlAccesoCano();
        
        // Estado inicial neutro
        resetearVista();
    }

    @FXML
    private void verificarAcceso(ActionEvent event) {
        String id = txtIdEntrada.getText();
        
        if (id.isEmpty()) return;

        ClienteCano cliente = gestorClientes.buscarPorId(id);
        
        ResultadoAcceso resultado = logicaAcceso.validarEntrada(cliente);

        actualizarInterfaz(resultado, cliente);

        txtIdEntrada.selectAll();
    }

    private void actualizarInterfaz(ResultadoAcceso resultado, ClienteCano cliente) {
        lblMensaje.setText(resultado.mensaje);
        
        if (cliente != null) {
            lblClienteInfo.setText(cliente.getNombre() + " " + cliente.getApellido() + 
                                   "\n" + cliente.getMembresiaActiva().getNombreMembresia());
        } else {
            lblClienteInfo.setText("---");
        }

        switch (resultado.estiloColor) {
            case "verde":
                lblEstado.setText("✅ ACCESO CONCEDIDO");
                panelEstado.setStyle("-fx-background-color: #2ecc71; -fx-background-radius: 10;"); 
                break;
            case "amarillo":
                lblEstado.setText("⚠️ REVISAR VIGENCIA");
                panelEstado.setStyle("-fx-background-color: #f1c40f; -fx-background-radius: 10;"); 
                break;
            case "rojo":
                lblEstado.setText("⛔ ACCESO DENEGADO");
                panelEstado.setStyle("-fx-background-color: #e74c3c; -fx-background-radius: 10;"); 
                break;
        }
    }
    
    private void resetearVista() {
        lblEstado.setText("ESPERANDO CLIENTE...");
        lblMensaje.setText("Ingrese su ID y presione Enter");
        lblClienteInfo.setText("");
        panelEstado.setStyle("-fx-background-color: #ecf0f1; -fx-background-radius: 10;"); // Gris
    }
    
    @FXML
    private void regresarMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gymposkc9822/view/MenuPrincipal.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setTitle("GymPOS - Menú Principal");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al intentar regresar al menú: " + e.getMessage());
        }
    }
}
