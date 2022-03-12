package co.com.sofka.domain.envio;

import co.com.sofka.domain.envio.event.EnvioCreado;
import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.envio.value.*;
import co.com.sofka.domain.ventas.VentaChange;
import co.com.sofka.domain.ventas.value.VentaID;
import co.com.sofka.domain.ventas.value.Fecha;
import java.util.Objects;
import java.util.Set;

public class Envio extends AggregateEvent<EnvioID> {

    protected DestinatarioID destinatarioID;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected VentaID ventaID;

    public Envio(EnvioID entityId,
                 Direccion direccion, Descripcion descripcion,
                 DomiciliarioID domiciliarioID, VentaID ventaID
                 , DestinatarioID destinatarioID
                 ) {
        super(entityId);
        subscribe(new EnvioChange(this));
        appendChange(new EnvioCreado(domiciliarioID,destinatarioID,
                direccion, descripcion,ventaID, fecha));

    }
    private Envio(EnvioID entityId) {
        super(entityId);
        subscribe(new EnvioChange(this));
    }
}
