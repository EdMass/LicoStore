package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.OrdenID;
import co.com.sofka.domain.ventas.value.VentaID;

public class CrearOrden extends Command {

    private final VentaID ventaID;
    private final OrdenID ordenID;

    public CrearOrden(VentaID ventaID, OrdenID ordenID) {
        this.ordenID = ordenID;
        this.ventaID = ventaID;
    }

    public OrdenID getOrdenID() {
        return ordenID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }
}
