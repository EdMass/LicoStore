package co.com.sofka.domain.ventas;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends Entity<ClienteID> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected List<Cliente> clientes = new ArrayList();


    public Cliente(ClienteID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(ClienteID clienteID) {
        super(clienteID);
    }


    public Cliente buscarClientePorID(ClienteID clienteID) {
        Cliente cliente1 = new Cliente(clienteID);
        Cliente cliente2 = new Cliente(clienteID);
        for (Cliente cliente : clientes) {
            if (cliente.entityId.equals(clienteID)) {
                cliente1.nombre = cliente.Nombre();
                cliente1.telefono = cliente.Telefono();
                return cliente1;
            }
        }
        crearCliente(clienteID, nombre, telefono);
        for (Cliente cliente3 : clientes) {
            if (cliente3.entityId.equals(clienteID)) {
                cliente2.nombre = cliente3.Nombre();
                cliente2.telefono = cliente3.Telefono();
            }
        }

        return cliente2;
    }


    public void crearCliente(ClienteID clienteId, Nombre nombre, Telefono telefono) {
        for (Cliente cliente : clientes) {
            if (cliente.entityId.equals(clienteId)) {
                System.out.println("Cliente ya existe");
            } else {
                Cliente clientito = new Cliente(clienteId, nombre, telefono);
                clientes.add(clientito);
            }

        }
    }

    public void eliminarCliente(ClienteID clienteId) {
        for (Cliente cliente : clientes) {
            if (cliente.entityId.equals(clienteId)) {
                clientes.remove(cliente);
            } else {
                System.out.println("Cliente no encontrado");
            }
        }
    }

    public void actualizarCliente(ClienteID clienteId, Nombre nombre, Telefono telefono) {
        eliminarCliente(clienteId);
        crearCliente(clienteId, nombre, telefono);
    }


    public Telefono Telefono() {
        return telefono;
    }

    public List<Cliente> Clientes() {
        return clientes;
    }

    public Nombre Nombre() {
        return nombre;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(telefono, cliente.telefono) && Objects.equals(Clientes(), cliente.Clientes());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
