package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;

public class ClienteAsignado extends DomainEvent {

    private final ClienteID clienteID;
    private final Nombre nombre;
    private final Telefono telefono;

    public ClienteAsignado(ClienteID clienteID, Nombre nombre, Telefono telefono) {
        super("sofka.venta.clienteasignado");
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
