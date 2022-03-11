package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.Total;

public class TotalCalculado extends DomainEvent {
   private final Total total;

    public TotalCalculado(Total total) {
        super("sofka.venta.totalcalculado  ");
        this.total = total;
    }

    public Total getTotal() {
        return total;
    }
}
