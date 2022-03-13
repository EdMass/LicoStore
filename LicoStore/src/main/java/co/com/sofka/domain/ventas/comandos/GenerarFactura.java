package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.Factura;
import co.com.sofka.domain.ventas.value.VentaID;

public class GenerarFactura extends Command {

    private final VentaID ventaID;
    private final Factura factura;

    public GenerarFactura(VentaID ventaID, Factura factura) {
        this.ventaID = ventaID;
        this.factura = factura;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public Factura getFactura() {
        return factura;
    }
}
