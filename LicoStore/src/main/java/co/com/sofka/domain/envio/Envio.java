package co.com.sofka.domain.envio;

import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.envio.value.*;


import java.util.Objects;
import java.util.Set;

public class Envio extends AggregateEvent<EnvioID> {

    protected Destinatario destinatario;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Set<Domiciliario> domiciliarios;

    public Envio(EnvioID entityId) {
        super(entityId);
    }
}
