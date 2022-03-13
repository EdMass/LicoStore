package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.Total;
import co.com.sofka.domain.ventas.value.VentaID;

public class CalcularTotal extends Command {
    private final Total total;
    private final VentaID ventaID;

    public CalcularTotal(VentaID ventaID, Total total) {
        this.ventaID = ventaID;
        this.total = total;

    }

    public Total getTotal() {
        return total;
    }

    public VentaID getVentaID() {
        return ventaID;
    }
}
