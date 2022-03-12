package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.Descripcion;
import co.com.sofka.domain.inventario.value.NombreInventario;
import co.com.sofka.domain.inventario.value.Precio;
import co.com.sofka.domain.inventario.value.ProductoID;

public class ProductoCreado extends DomainEvent {

    private final ProductoID productoID;
    private final NombreInventario nombreInventario;
    private final Precio precio;
    private final Descripcion descripcion;

    public ProductoCreado(ProductoID productoID, NombreInventario nombreInventario, Precio precio, Descripcion descripcion) {
        super("sofka.inventario.productocreado");
        this.productoID = productoID;
        this.nombreInventario = nombreInventario;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public NombreInventario getNombre() {
        return nombreInventario;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
