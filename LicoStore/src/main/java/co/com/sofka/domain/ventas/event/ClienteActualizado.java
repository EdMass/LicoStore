package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.value.ClienteID;

public class ClienteActualizado extends DomainEvent {

    private final Cliente cliente;

    public ClienteActualizado( Cliente cliente) {
        super("sofka.venta.clienteactualizado");

        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
