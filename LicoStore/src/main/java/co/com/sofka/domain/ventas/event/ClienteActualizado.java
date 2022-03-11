package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.value.ClienteID;

public class ClienteActualizado extends DomainEvent {

    private final ClienteID clienteID;
    private final Cliente cliente;

    public ClienteActualizado(ClienteID clienteID, Cliente cliente) {
        super("sofka.venta.clienteactualizado");
        this.clienteID = clienteID;
        this.cliente = cliente;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
