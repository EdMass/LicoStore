package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.VendedorID;

public class VendedorAsignado extends DomainEvent {

    private final VendedorID vendedorID;

    public VendedorAsignado(VendedorID vendedorID) {
        super("sofka.venta.vendedorasignado");
        this.vendedorID =vendedorID;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}
