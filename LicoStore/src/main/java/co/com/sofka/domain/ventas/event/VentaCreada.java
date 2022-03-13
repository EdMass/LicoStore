package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.*;

public class VentaCreada extends DomainEvent {

    private final VentaID ventaID;
    private final Fecha fecha;


    public VentaCreada(VentaID ventaID, Fecha fecha) {
        super("sofka.venta.ventacreada");
        this.fecha = fecha;
        this.ventaID = ventaID;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public VentaID getVentaID() {
        return ventaID;
    }
}
