package service;

import gymposkc9822.model.Empleado;

public class SistemaAutenticacion {

    public Empleado login(String usuario, String password) {
        
        if (usuario.equals("1979822") && password.equals("adminkelly")) {
            return new Empleado("1979822", "adminkelly", "Kelly Cano", "ADMINISTRADOR");
        }

        return null;
    }
}
