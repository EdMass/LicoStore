package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.VendedorID;
import co.com.sofka.domain.ventas.value.VentaID;

public class VentaAgregadaAVendedor extends DomainEvent {

    private final VentaID ventaID;
    private final VendedorID vendedorID;

    public VentaAgregadaAVendedor(VentaID ventaID, VendedorID vendedorID) {
        super("sofka.venta.ventaagregadaavendedor");
        this.ventaID = ventaID;
        this.vendedorID = vendedorID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}
