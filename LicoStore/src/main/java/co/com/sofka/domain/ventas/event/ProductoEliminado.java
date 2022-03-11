package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.ProductoID;

public class ProductoEliminado extends DomainEvent {

    private final ProductoID productoID;

    public ProductoEliminado(ProductoID productoID) {
        super("sofka.venta.productoeliminado");
        this.productoID = productoID;
    }

    public ProductoID getProductoID() {
        return productoID;
    }
}
