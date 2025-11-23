package service;

import gymposkc9822.model.ClienteCano;
import gymposkc9822.model.Pago9822;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProcesadorPagos9822 {

    private List<Pago9822> historialPagos;
    private final String ARCHIVO_PAGOS = "pagos_historial.dat";

    public ProcesadorPagos9822() {
        historialPagos = new ArrayList<>();
        cargarPagos();
    }

    public Pago9822 procesarNuevoPago(ClienteCano cliente, String metodoPago) {
        if (cliente == null || cliente.getMembresiaActiva() == null) {
            return null; 
        }

        double precioBase = cliente.getMembresiaActiva().getCosto();
        double precioFinal = ajustarCentavos(precioBase);

        String idPago = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Pago9822 nuevoPago = new Pago9822(
                idPago,
                cliente,
                LocalDate.now(),
                precioFinal,
                metodoPago
        );

        historialPagos.add(nuevoPago);
        guardarPagos();

        return nuevoPago;
    }

    private double ajustarCentavos(double cantidad) {
        long parteEntera = (long) cantidad;
        return parteEntera + 0.22;
    }

    public List<Pago9822> obtenerHistorial() {
        return historialPagos;
    }

    private void guardarPagos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PAGOS))) {
            oos.writeObject(historialPagos);
        } catch (IOException e) {
            System.err.println("Error al guardar pagos: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    private void cargarPagos() {
        File archivo = new File(ARCHIVO_PAGOS);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                historialPagos = (List<Pago9822>) ois.readObject();
            } catch (Exception e) {
                historialPagos = new ArrayList<>();
            }
        }
    }
}