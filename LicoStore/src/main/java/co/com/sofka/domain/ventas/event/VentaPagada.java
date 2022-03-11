package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.Pago;

public class VentaPagada extends DomainEvent {

    private final Pago pago;

    public VentaPagada(Pago pago) {
        super("sofka.venta.ventapagada");
        this.pago = pago;
    }

    public Pago getPago() {
        return pago;
    }
}
