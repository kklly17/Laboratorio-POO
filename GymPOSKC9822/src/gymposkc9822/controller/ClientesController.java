package gymposkc9822.controller;

import service.GestionClientesCano; 
import gymposkc9822.model.ClienteCano;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;
import service.SistemaMembresias1703;
import gymposkc9822.model.Membresias0317;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class ClientesController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEmail;
    @FXML private TextField txtTelefono;
    
    @FXML private ComboBox<Membresias0317> cmbMembresia;
    
    @FXML private TableView<ClienteCano> tablaClientes;
    @FXML private TableColumn<ClienteCano, String> colId;
    @FXML private TableColumn<ClienteCano, String> colNombre;
    @FXML private TableColumn<ClienteCano, String> colApellido;
    @FXML private TableColumn<ClienteCano, String> colEmail;
    @FXML private TableColumn<ClienteCano, String> colTelefono;
    @FXML private TableColumn<ClienteCano, String> colMembresia;

    @FXML private TableColumn<?, ?> colFechaRegistro;
    @FXML private TableColumn<?, ?> colPuntos;

    private GestionClientesCano gestorDatos;
    private SistemaMembresias1703 sistemaMembresias;
    private ObservableList<ClienteCano> listaObservable; 

    @FXML
    public void initialize() {
        gestorDatos = new GestionClientesCano();
        sistemaMembresias = new SistemaMembresias1703();
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        colMembresia.setCellValueFactory(cellData -> {
            Membresias0317 m = cellData.getValue().getMembresiaActiva();
            if (m != null) {
                return new SimpleStringProperty(m.getNombreMembresia());
            } else {
                return new SimpleStringProperty("Sin Plan");
            }
        });
        
        cmbMembresia.setItems(FXCollections.observableArrayList(
            sistemaMembresias.obtenerMembresiasDisponibles()
        ));
        
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        listaObservable = FXCollections.observableArrayList(gestorDatos.obtenerTodos());
        tablaClientes.setItems(listaObservable);
    }

    private void limpiarFormulario() {
        txtId.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEmail.clear();
        txtTelefono.clear();
    }
    
    //  Boton AGREGAR
    @FXML
    private void agregarCliente(ActionEvent event) {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String email = txtEmail.getText();
        String telefono = txtTelefono.getText();

        if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", "Por favor llena ID, Nombre y Apellido.");
            return;
        }
        if (!validarCampos()) return;
        try {
           
            ClienteCano nuevo = new ClienteCano(id, nombre, apellido, email, telefono);
            
            Membresias0317 planSeleccionado = cmbMembresia.getValue();
            
            if (planSeleccionado != null) {
                nuevo.setMembresiaActiva(planSeleccionado); 

                int puntos = (int)(planSeleccionado.getCosto() * 0.10);
                nuevo.agregarPuntos(puntos);
            }
            gestorDatos.agregarCliente(nuevo); 
 
            cargarDatosEnTabla();
            tablaClientes.refresh();
            limpiarFormulario(); 
            
            mostrarAlerta("Éxito", "Cliente Agregado", "El cliente se guardó correctamente.");

        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo guardar", e.getMessage());
        }
    }

    //  Botón ELIMINAR
    @FXML
    private void eliminarCliente(ActionEvent event) {
        ClienteCano seleccionado = tablaClientes.getSelectionModel().getSelectedItem();
        
        if (seleccionado == null) {
            mostrarAlerta("Advertencia", "Nada seleccionado", "Por favor selecciona un cliente de la tabla.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Eliminar Cliente");
        confirmacion.setContentText("¿Estás seguro de eliminar a " + seleccionado.getNombre() + "?");
        Optional<ButtonType> resultado = confirmacion.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            try {
                gestorDatos.eliminarCliente(seleccionado.getId());
                cargarDatosEnTabla();
                mostrarAlerta("Éxito", "Eliminado", "Cliente eliminado correctamente.");
            } catch (Exception e) {
                mostrarAlerta("Error", "Fallo al eliminar", e.getMessage());
            }
        }
    }

    @FXML
    private void limpiarCampos(ActionEvent event) {
        // Simplemente llama a nuestro método interno
        limpiarFormulario();
    }
    @FXML
    private void actualizarCliente(ActionEvent event) {
   
        String id = txtId.getText();
        if (id.isEmpty()) {
            mostrarAlerta("Error", "ID Requerido", "Primero busca o selecciona un cliente para actualizar.");
            return;
        }

        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()) {
            mostrarAlerta("Error", "Campos incompletos", "Nombre y apellido no pueden estar vacíos.");
            return;
        }

        if (!validarCampos()) return;

        try {
            ClienteCano clienteExistente = gestorDatos.buscarPorId(id);

            if (clienteExistente == null) {
                mostrarAlerta("Error", "No existe", "El cliente con ID " + id + " no existe en la base de datos.");
                return;
            }

            clienteExistente.setNombre(txtNombre.getText());
            clienteExistente.setApellido(txtApellido.getText());
            clienteExistente.setEmail(txtEmail.getText());
            clienteExistente.setTelefono(txtTelefono.getText());
            Membresias0317 nuevaMembresia = cmbMembresia.getValue();
            if (nuevaMembresia != null) {
                clienteExistente.setMembresiaActiva(nuevaMembresia);
            }
            gestorDatos.actualizarCliente(clienteExistente);

            cargarDatosEnTabla();
            tablaClientes.refresh();
            limpiarFormulario();

            mostrarAlerta("Éxito", "Actualizado", "Los datos del cliente se actualizaron correctamente.");

        } catch (Exception e) {
            mostrarAlerta("Error", "Fallo al actualizar", e.getMessage());
        }
    }


    @FXML
    private void buscarCliente(ActionEvent event) {
        String idBusqueda = txtId.getText();
        
        if (idBusqueda.isEmpty()) {
            mostrarAlerta("Error", "Campo ID vacío", "Ingresa un ID para buscar.");
            return;
        }

        ClienteCano clienteEncontrado = gestorDatos.buscarPorId(idBusqueda);

        if (clienteEncontrado != null) {
     
            txtNombre.setText(clienteEncontrado.getNombre());
            txtApellido.setText(clienteEncontrado.getApellido());
            txtEmail.setText(clienteEncontrado.getEmail());
            txtTelefono.setText(clienteEncontrado.getTelefono());
            
            mostrarAlerta("Cliente Encontrado", "Datos cargados", 
                          "Puedes editar la información y presionar 'Actualizar'.");
        } else {
            mostrarAlerta("Error", "No encontrado", "No existe ningún cliente con el ID: " + idBusqueda);
        }
    }
    
    private void mostrarAlerta(String titulo, String header, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
    
    
    private boolean validarCampos() {

        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String email = txtEmail.getText().trim();
        String telefono = txtTelefono.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            mostrarAlerta("Validación", null, 
                          "ID, Nombre y Apellido son obligatorios.");
            return false;
        }

        if (!email.isEmpty()) {
            if (!email.matches("^.+@.+\\..+$")) { 
                mostrarAlerta("Validación", null, 
                              "El email no tiene un formato válido.");
                return false;
            }
        }

        if (!telefono.isEmpty()) {
            if (!telefono.matches("\\d{8,15}")) {
                mostrarAlerta("Validación", null, 
                              "El teléfono debe ser numérico (8 a 15 dígitos).");
                return false;
            }
        }
        return true; 
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

