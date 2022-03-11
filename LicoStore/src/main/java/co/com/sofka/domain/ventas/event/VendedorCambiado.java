package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.VendedorID;

public class VendedorCambiado extends DomainEvent {

    private final VendedorID vendedorID;

    public VendedorCambiado(VendedorID vendedorID) {
        super("sofka.venta.vendedorCambiado");
        this.vendedorID =vendedorID;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}
