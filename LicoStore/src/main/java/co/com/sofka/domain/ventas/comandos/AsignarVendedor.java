package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;
import co.com.sofka.domain.ventas.value.VendedorID;
import co.com.sofka.domain.ventas.value.VentaID;

public class AsignarVendedor extends Command {
    private final VentaID ventaID;
    private final VendedorID vendedorID;
    private final Nombre nombre;
    private final Telefono telefono;

    public AsignarVendedor(VentaID ventaID, VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ventaID = ventaID;
        this.vendedorID = vendedorID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
