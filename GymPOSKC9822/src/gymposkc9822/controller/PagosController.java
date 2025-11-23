package gymposkc9822.controller;


import service.GestionClientesCano;
import service.ProcesadorPagos9822;
import gymposkc9822.model.ClienteCano;
import gymposkc9822.model.Pago9822;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PagosController {

    @FXML private ComboBox<ClienteCano> cmbClientes;
    @FXML private Label lblPlan;
    @FXML private Label lblMonto;
    @FXML private TableView<Pago9822> tablaHistorial;
    @FXML private TableColumn<Pago9822, String> colFecha;
    @FXML private TableColumn<Pago9822, String> colCliente;
    @FXML private TableColumn<Pago9822, Double> colMonto;

    private GestionClientesCano gestorClientes;
    private ProcesadorPagos9822 procesadorPagos;

    @FXML
    public void initialize() {
        gestorClientes = new GestionClientesCano();
        procesadorPagos = new ProcesadorPagos9822();

        cmbClientes.setItems(FXCollections.observableArrayList(gestorClientes.obtenerTodos()));

        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaPago"));
        colCliente.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
             cellData.getValue().getCliente().getNombre() + " " + cellData.getValue().getCliente().getApellido()
        ));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        
        cargarHistorial();

        cmbClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null && newVal.getMembresiaActiva() != null) {
                lblPlan.setText(newVal.getMembresiaActiva().getNombreMembresia());
                lblMonto.setText("$" + newVal.getMembresiaActiva().getCosto());
            } else {
                lblPlan.setText("---");
                lblMonto.setText("$0.00");
            }
        });
    }

    private void cargarHistorial() {
        tablaHistorial.setItems(FXCollections.observableArrayList(procesadorPagos.obtenerHistorial()));
    }

    @FXML
    private void realizarCobro(ActionEvent event) {
        ClienteCano cliente = cmbClientes.getValue();

        if (cliente == null || cliente.getMembresiaActiva() == null) {
            mostrarAlerta("Error", "Selecciona un cliente con plan activo.");
            return;
        }

        String[] metodos = {"Efectivo", "Tarjeta", "Transferencia"};
        ChoiceDialog<String> dialogo = new ChoiceDialog<>(metodos[0], metodos);
        dialogo.setTitle("Cobrar");
        dialogo.setContentText("Método de Pago:");

        dialogo.showAndWait().ifPresent(metodo -> {
            Pago9822 nuevoPago = procesadorPagos.procesarNuevoPago(cliente, metodo);
            cargarHistorial();
            mostrarAlerta("Pago Exitoso", "Ticket: " + nuevoPago.getIdPago() + "\nMonto: $" + nuevoPago.getMonto());
        });
    }
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(contenido);
        alert.showAndWait();
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
