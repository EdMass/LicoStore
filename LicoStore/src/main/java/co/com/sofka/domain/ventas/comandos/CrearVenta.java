package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Fecha;
import co.com.sofka.domain.ventas.value.VendedorID;
import co.com.sofka.domain.ventas.value.VentaID;

public class CrearVenta extends Command {
    private final VentaID ventaID;
    private final ClienteID clienteID;
    private final VendedorID vendedorID;
    private final Fecha fecha;

    public CrearVenta(VentaID ventaID, ClienteID clienteID, VendedorID vendedorID, Fecha fecha){
        this.ventaID=ventaID;
        this.clienteID=clienteID;
        this.vendedorID= vendedorID;
        this.fecha=fecha;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
