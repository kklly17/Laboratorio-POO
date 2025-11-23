package service;

import gymposkc9822.model.ClienteCano;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GestionClientesCano {

    private List<ClienteCano> listaClientes;
    private final String ARCHIVO_DB = "clientes_cano_db.dat";

    public GestionClientesCano() {
        listaClientes = new ArrayList<>();
        cargarDatos();
    }

    public void agregarCliente(ClienteCano nuevoCliente) throws Exception {
      
        for (ClienteCano c : listaClientes) {
            if (c.getId().equals(nuevoCliente.getId())) {
                throw new Exception("Error: El ID del cliente ya existe.");
            }
        }
        listaClientes.add(nuevoCliente);
        guardarDatos(); 
    }

    public List<ClienteCano> obtenerTodos() {
        return listaClientes;
    }
    
    public ClienteCano buscarPorId(String id) {
        for (ClienteCano c : listaClientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null; 
    }

    public void actualizarCliente(ClienteCano clienteEditado) throws Exception {
        boolean encontrado = false;
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId().equals(clienteEditado.getId())) {
                listaClientes.set(i, clienteEditado);
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            guardarDatos();
        } else {
            throw new Exception("Cliente no encontrado para actualizar.");
        }
    }

    public void eliminarCliente(String id) throws Exception {
        boolean eliminado = listaClientes.removeIf(c -> c.getId().equals(id));
        
        if (eliminado) {
            guardarDatos();
        } else {
            throw new Exception("No se encontró el cliente con ese ID.");
        }
    }

    
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DB))) {
            oos.writeObject(listaClientes);
        } catch (IOException e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        File archivo = new File(ARCHIVO_DB);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                listaClientes = (List<ClienteCano>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar datos: " + e.getMessage());
                listaClientes = new ArrayList<>();
            }
        }
    }
}