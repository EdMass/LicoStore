package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.envio.value.Direccion;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.ClienteID;

public class DireccionDestinatarioAsignada extends DomainEvent {
    private ClienteID clienteID;
    private Direccion direccion;

    public DireccionDestinatarioAsignada(ClienteID clienteID, Direccion direccion){
        super("sofka.envio.direcciondestinatarioasignada");
        this.clienteID=clienteID;
        this.direccion=direccion;

    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
