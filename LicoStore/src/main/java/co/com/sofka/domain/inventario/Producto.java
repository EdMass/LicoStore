package co.com.sofka.domain.inventario;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.value.*;

public class Producto extends Entity<ProductoID> {

    protected Nombre nombre;
    protected Precio precio;
    protected Descripcion descripcion;
    protected Cantidad cantidad;
    protected ProveedorID proveedorID;

    public Producto (ProductoID entityId, Nombre nombre,Precio precio, Descripcion descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.precio= precio;
        this.descripcion= descripcion;
    }

    public Producto(ProductoID entityId,
                    Nombre nombre,
                    Precio precio,
                    Descripcion descripcion,
                    Cantidad cantidad) {
        super(entityId);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(ProductoID entityId, Nombre nombre, ProveedorID proveedorID) {
        super(entityId);
        this.nombre = nombre;
        this.proveedorID = proveedorID;
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

    public Cantidad Cantidad() {
        return cantidad;
    }

    public ProveedorID VendedorID() {
        return proveedorID;
    }
}