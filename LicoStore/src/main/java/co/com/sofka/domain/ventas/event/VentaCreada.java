package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.*;

public class VentaCreada extends DomainEvent {


    private final VendedorID vendedorID;
    private final Fecha fecha;


    public VentaCreada(VendedorID vendedorID, Fecha fecha) {
        super("sofka.venta.ventacreada");

        this.vendedorID = vendedorID;

        this.fecha= fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }

}
