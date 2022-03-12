package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.*;

public class ProductoAgregado extends DomainEvent {

    private final ProductoID productoID;
    private final NombreInventario nombreInventarioProducto;
    private final Precio precio;
    private final Descripcion descripcion;
    private final Cantidad cantidad;

    public ProductoAgregado(ProductoID productoID,
                            NombreInventario nombreInventarioProducto,
                            Precio precio,
                            Descripcion descripcion,
                            Cantidad cantidad) {
        super("sofka.venta.productoagregado");
        this.productoID = productoID;
        this.nombreInventarioProducto = nombreInventarioProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public NombreInventario getNombreProducto() {
        return nombreInventarioProducto;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
