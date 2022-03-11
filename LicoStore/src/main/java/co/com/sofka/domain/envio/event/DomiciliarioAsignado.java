package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.envio.value.DomiciliarioID;
import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.DomainEvent;

public class DomiciliarioAsignado extends DomainEvent {
    private final EnvioID envioID;
    private final DomiciliarioID domiciliarioID;
    public DomiciliarioAsignado(EnvioID envioID, DomiciliarioID domiciliarioID){
        super("sofka.envio.domiciliarioasignado");
        this.envioID= envioID;
        this.domiciliarioID= domiciliarioID;
    }

    public DomiciliarioID getDomiciliarioID() {
        return domiciliarioID;
    }

    public EnvioID getEnvioID() {
        return envioID;
    }
}
