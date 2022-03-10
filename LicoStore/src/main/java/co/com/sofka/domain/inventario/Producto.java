package co.com.sofka.domain.inventario;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.value.ProductoID;
import co.com.sofka.domain.inventario.value.Precio;
import co.com.sofka.domain.inventario.value.Nombre;
import co.com.sofka.domain.inventario.value.Descripcion;

public class Producto extends Entity<ProductoID> {

    protected Nombre nombre;
    protected Precio precio;
    protected Descripcion descripcion;

    public Producto (ProductoID entityId, Nombre nombre,Precio precio, Descripcion descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.precio= precio;
        this.descripcion= descripcion;
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
}