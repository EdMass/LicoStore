package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.envio.value.Telefono;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.ClienteID;

public class TelefonoDestinatarioAsignado extends DomainEvent {

    private final ClienteID clienteID;
    private final Telefono telefono;

    public TelefonoDestinatarioAsignado(ClienteID clienteID, Telefono telefono){

        super("sofka.envio.telefonodestinatarioasignado");
        this.clienteID = clienteID;
        this.telefono = telefono;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
