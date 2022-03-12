package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.Descripcion;
import co.com.sofka.domain.inventario.value.Nombre;
import co.com.sofka.domain.inventario.value.Precio;
import co.com.sofka.domain.inventario.value.ProductoID;

public class ProductoCreado extends DomainEvent {

    private final ProductoID productoID;
    private final Nombre nombre;
    private final Precio precio;
    private final Descripcion descripcion;

    public ProductoCreado(ProductoID productoID, Nombre nombre, Precio precio, Descripcion descripcion) {
        super("sofka.inventario.productocreado");
        this.productoID = productoID;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
