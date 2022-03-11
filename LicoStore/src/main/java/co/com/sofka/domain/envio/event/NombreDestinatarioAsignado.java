package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;


public class NombreDestinatarioAsignado extends DomainEvent {
    private final ClienteID clienteID;
    private final Nombre nombre;

    public NombreDestinatarioAsignado(ClienteID clienteID, Nombre nombre) {
        super("sofka.envio.nombredestinatarioasignado");
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
