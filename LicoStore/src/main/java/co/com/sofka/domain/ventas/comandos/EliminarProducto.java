package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.inventario.value.ProductoID;
import co.com.sofka.domain.ventas.value.VentaID;

public class EliminarProducto extends Command {

    private final VentaID ventaID;
    private final ProductoID productoID;

    public EliminarProducto(VentaID ventaID, ProductoID productoID) {
        this.ventaID = ventaID;
        this.productoID = productoID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public ProductoID getProductoID() {
        return productoID;
    }
}
