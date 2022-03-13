package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.VendedorID;
import co.com.sofka.domain.ventas.value.VentaID;

public class AsignarVendedor extends Command {
    private final VentaID ventaID;
    private final VendedorID vendedorID;

    public AsignarVendedor(VentaID ventaID, VendedorID vendedorID){

        this.ventaID=ventaID;
        this.vendedorID= vendedorID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}
