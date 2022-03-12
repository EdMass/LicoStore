package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.value.VentaID;

public class AgregarProductoAOrden extends Command {

    //siempre va el id del agregado root
    private final VentaID ventaID;
    private final ProductoID productoID;
    private final NombreInventario nombreInventario;
    private final Precio precio;
    private final Descripcion descripcion;
    private final Cantidad cantidad;

    public AgregarProductoAOrden(VentaID ventaID, ProductoID productoID, NombreInventario nombreInventario, Precio precio, Descripcion descripcion, Cantidad cantidad) {
        this.ventaID = ventaID;
        this.productoID = productoID;
        this.nombreInventario = nombreInventario;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public NombreInventario getNombreInventario() {
        return nombreInventario;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
