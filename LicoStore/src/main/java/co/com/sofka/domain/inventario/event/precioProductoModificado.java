package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.Precio;
import co.com.sofka.domain.inventario.value.ProductoID;

public class precioProductoModificado extends DomainEvent {

    private final ProductoID productoID;
    private final Precio precio;

    public precioProductoModificado(ProductoID productoID, Precio precio) {
        super("sofka.inventario.precioproductomodificado");
        this.productoID = productoID;
        this.precio = precio;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public Precio getPrecio() {
        return precio;
    }
}
