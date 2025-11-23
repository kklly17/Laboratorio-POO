
package gymposkc9822.controller;

import service.SistemaAutenticacion;
import gymposkc9822.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnIngresar;

    private SistemaAutenticacion auth;

    @FXML
    public void initialize() {
        auth = new SistemaAutenticacion();
    }

    @FXML
    private void manejarLogin(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarError("Campos vacíos", "Por favor ingresa usuario y contraseña.");
            return;
        }
        Empleado empleado = auth.login(usuario, password);

        if (empleado != null) {
            irAMenuPrincipal();
        } else {
            mostrarError("Acceso Denegado", "Usuario o contraseña incorrectos.");
        }
    }

    private void irAMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gymposkc9822/view/MenuPrincipal.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            Scene scene = new Scene(root);
            
            stage.setTitle("GymPOSKC9822 - Menú Principal");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("Error Crítico", "No se pudo cargar el Menú Principal.");
        }
    }
    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
}