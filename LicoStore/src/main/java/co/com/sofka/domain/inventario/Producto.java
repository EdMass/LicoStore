package co.com.sofka.domain.inventario;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.value.OrdenID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Producto extends Entity<ProductoID> {

    protected NombreInventario nombreInventario;
    protected Precio precio;
    protected Descripcion descripcion;
    protected Cantidad cantidad;
    protected ProveedorID proveedorID;
    private List<Producto> productosInventario = new ArrayList<>();

    public Producto (ProductoID entityId, NombreInventario nombreInventario, Precio precio, Descripcion descripcion) {
        super(entityId);
        this.nombreInventario = nombreInventario;
        this.precio= precio;
        this.descripcion= descripcion;
    }

    //Producto para Orden
    public Producto(ProductoID entityId,
                    NombreInventario nombreInventario,
                    Precio precio,
                    Descripcion descripcion,
                    Cantidad cantidad) {
        super(entityId);
        this.nombreInventario = nombreInventario;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    //Producto para inventario
    public Producto(ProductoID entityId, NombreInventario nombreInventario, ProveedorID proveedorID) {
        super(entityId);
        this.nombreInventario = nombreInventario;
        this.proveedorID = proveedorID;
    }

    public Producto(ProductoID entityId) {
        super(entityId);
    }


    public NombreInventario Nombre() {
        return nombreInventario;
    }

    public Precio Precio() {
        return precio;
    }

    public Descripcion Descripcion() {
        return descripcion;
    }

    public Cantidad Cantidad() {
        return cantidad;
    }

    public ProveedorID VendedorID() {
        return proveedorID;
    }


    public List<Producto> getProductosInventario() {
        return productosInventario;
    }
}