package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.VendedorID;
import co.com.sofka.domain.ventas.value.VentaID;

public class VendedorAsignado extends DomainEvent {

    private final VendedorID vendedorID;
    private final VentaID ventaID;

    public VendedorAsignado(VendedorID vendedorID, VentaID ventaID) {
        super("sofka.venta.vendedorasignado");
        this.vendedorID =vendedorID;
        this.ventaID= ventaID;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}
