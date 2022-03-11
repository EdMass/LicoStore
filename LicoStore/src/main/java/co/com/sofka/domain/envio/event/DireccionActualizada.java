package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.envio.value.DestinatarioID;
import co.com.sofka.domain.envio.value.Direccion;
import co.com.sofka.domain.generic.DomainEvent;

public class DireccionActualizada extends DomainEvent {
    private final Direccion direccion;
    private final DestinatarioID destinatarioID;
    public DireccionActualizada(Direccion direccion, DestinatarioID destinatarioID){
        super("sofka.envio.direccionactualizada");
        this.direccion=direccion;
        this.destinatarioID= destinatarioID;

    }

    public Direccion getDireccion() {
        return direccion;
    }

    public DestinatarioID getDestinatarioID() {
        return destinatarioID;
    }
}
