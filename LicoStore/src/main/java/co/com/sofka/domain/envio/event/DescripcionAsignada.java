package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.envio.value.Descripcion;
import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionAsignada extends DomainEvent {


    private final Descripcion descripcion;
    private final EnvioID envioID;

    public DescripcionAsignada(EnvioID envioID, Descripcion descripcion) {
        super("sofka.envio.descripcionasignada");
        this.descripcion = descripcion;
        this.envioID = envioID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public EnvioID getEnvioID() {
        return envioID;
    }
}
