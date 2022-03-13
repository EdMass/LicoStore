package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.OrdenID;

public class OrdenCreada extends DomainEvent {

    private final OrdenID ordenID;

    public OrdenCreada(OrdenID ordenID) {
        super("sofka.venta.ordencreada");
        this.ordenID = ordenID;
    }

    public OrdenID getOrdenID() {
        return ordenID;
    }
}
