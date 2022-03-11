package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.inventario.value.*;

public class ProductoAgregado extends DomainEvent {

    private final InventarioID inventarioID;
    private final Producto producto;

    public ProductoAgregado(InventarioID inventarioID, Producto producto) {
        super("sofka.venta.productoagregado");
        this.inventarioID = inventarioID;
        this.producto = producto;
    }

    public InventarioID getInventarioID() {
        return inventarioID;
    }

    public Producto getProducto() {
        return producto;
    }
}
