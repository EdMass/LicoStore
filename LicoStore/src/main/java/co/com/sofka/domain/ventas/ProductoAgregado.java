package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.value.Nombre;

public class ProductoAgregado extends DomainEvent {

    private final ProductoID productoID;
    private final Nombre nombreProducto;
    private final Precio precio;
    private final Cantidad cantidad;

    public ProductoAgregado(ProductoID productoID,
                            Nombre nombreProducto,
                            Precio precio,
                            Cantidad cantidad) {
        super("sofka.venta.productoagregado");
        this.productoID = productoID;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public Nombre getNombreProducto() {
        return nombreProducto;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

}
