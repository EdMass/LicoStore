package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.Factura;

public class FacturaGenerada extends DomainEvent {

    private final Factura factura;

    public FacturaGenerada(Factura factura) {
        super("sofka.venta.facturagenerada");
        this.factura = factura;
    }

    public Factura getFactura() {
        return factura;
    }
}
