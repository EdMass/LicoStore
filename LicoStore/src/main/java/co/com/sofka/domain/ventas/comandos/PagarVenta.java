package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.Pago;
import co.com.sofka.domain.ventas.value.VentaID;


public class PagarVenta extends Command {
    private final Pago pago;
    private final VentaID ventaID;


    public PagarVenta(Pago pago, VentaID ventaID){
        this.pago=pago;
        this.ventaID=ventaID;
    }

    public Pago getPago() {
        return pago;
    }

    public VentaID getVentaID() {
        return ventaID;
    }
}
