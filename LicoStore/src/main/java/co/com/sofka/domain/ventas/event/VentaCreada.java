package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.*;

public class VentaCreada extends DomainEvent {


    private final Fecha fecha;


    public VentaCreada(Fecha fecha) {
        super("sofka.venta.ventacreada");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }


}
