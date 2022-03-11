package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Entity<ClienteID> {

    protected Nombre nombre;
    protected Telefono telefono;
    private List<Cliente> clientes = new ArrayList();

    public Cliente(ClienteID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void crearCliente(ClienteID clienteId, Nombre nombre, Telefono telefono){
        for (Cliente cliente: clientes) {
            if(cliente.entityId.equals(clienteId)){
                System.out.println("Cliente ya existe");
            }
            Cliente clientito = new Cliente(clienteId, nombre, telefono);
            clientes.add(clientito);
        }
    }

    public void eliminarCliente(ClienteID clienteId){
        for (Cliente cliente:clientes) {
            if(cliente.entityId.equals(clienteId)){
                clientes.remove(cliente);
            }
            else{
                System.out.println("Cliente no encontrado");
            }
        }
    }

    public void actualizarCliente(ClienteID clienteId,Nombre nombre, Telefono telefono){
        eliminarCliente(clienteId);
        crearCliente(clienteId, nombre, telefono);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }
}
