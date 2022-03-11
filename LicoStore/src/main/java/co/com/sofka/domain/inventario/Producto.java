package co.com.sofka.domain.inventario;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.value.VendedorID;

public class Producto extends Entity<ProductoID> {

    protected Nombre nombre;
    protected Precio precio;
    protected Descripcion descripcion;
    protected Cantidad cantidad;
    protected VendedorID vendedorID;

    public Producto (ProductoID entityId, Nombre nombre,Precio precio, Descripcion descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.precio= precio;
        this.descripcion= descripcion;
    }

    public Producto(ProductoID entityId,
                    Nombre nombre, Precio precio,
                    Descripcion descripcion,
                    Cantidad cantidad) {
        super(entityId);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(ProductoID entityId, Nombre nombre, VendedorID vendedorID) {
        super(entityId);
        this.nombre = nombre;
        this.vendedorID = vendedorID;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Precio precio() {
        return precio;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}