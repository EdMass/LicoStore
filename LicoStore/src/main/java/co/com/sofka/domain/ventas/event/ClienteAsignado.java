package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.ClienteID;

public class ClienteAsignado extends DomainEvent {

    private final ClienteID clienteID;

    public ClienteAsignado(ClienteID clienteID) {
        super("sofka.venta.clienteasignado");
        this.clienteID = clienteID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }
}
