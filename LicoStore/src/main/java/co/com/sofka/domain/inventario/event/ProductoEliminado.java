package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.ProductoID;

public class ProductoEliminado extends DomainEvent {

    private final ProductoID productoID;

    public ProductoEliminado(ProductoID productoID) {
        super("sofka.inventario.productoeliminado");
        this.productoID = productoID;
    }

    public ProductoID getProductoID() {
        return productoID;
    }
}
