package gymposkc9822.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Pago9822 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idPago;
    private ClienteCano cliente;
    private LocalDate fechaPago;
    private double monto;
    private String metodoPago;
    
    // Constructores
    public Pago9822() {
    }

    public Pago9822(String idPago, ClienteCano cliente, LocalDate fechaPago, double monto, String metodoPago) {
        this.idPago = idPago;
        this.cliente = cliente;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }
    
    // Getters y Setters
    public String getIdPago() {
        return idPago;
    }
    
    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }
    
    public ClienteCano getCliente() {
        return cliente;
    }
    
    public void setCliente(ClienteCano cliente) {
        this.cliente = cliente;
    }
    
    public LocalDate getFechaPago() {
        return fechaPago;
    }
    
    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public String getMetodoPago() {
        return metodoPago;
    }
    
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    // Metodos

    public boolean validarPago() {
        return cliente != null && monto > 0;
    }
 
    public String generarComprobante() {
        return "Comprobante de Pago:\n" +
               "ID: " + idPago + "\n" +
               "Cliente: " + (cliente != null ? cliente.getNombre() + " " + cliente.getApellido() : "N/A") + "\n" +
               "Fecha: " + fechaPago + "\n" +
               "Monto: $" + monto + "\n" +
               "Método: " + metodoPago + "\n";
    }
    
    @Override
    public String toString() {
        return "Pago9822{" +
                "idPago='" + idPago + '\'' +
                ", cliente=" + (cliente != null ? cliente.getNombre() + " " + cliente.getApellido() : "N/A") +
                ", fechaPago=" + fechaPago +
                ", monto=" + monto +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}


