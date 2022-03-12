package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.Descripcion;
import co.com.sofka.domain.inventario.value.ProductoID;

public class DescripciondeProductoActualizada extends DomainEvent {

    private final ProductoID productoID;
    private final Descripcion newDescripcion;

    public DescripciondeProductoActualizada(ProductoID productoID, Descripcion newDescripcion) {
        super("sofka.inventario.descripciondeproductoactualizada");
        this.productoID = productoID;
        this.newDescripcion = newDescripcion;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public Descripcion getNewDescripcion() {
        return newDescripcion;
    }
}
