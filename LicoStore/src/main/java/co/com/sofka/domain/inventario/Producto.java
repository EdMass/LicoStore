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





/*
    public Producto buscarProductoPorIDenOrden(ProductoID productoID) {
        Producto producto1 = new Producto(productoID);
        Producto producto2 = new Producto(productoID);
        for (Producto producto : productosOrden) {
            if (producto.identity().equals(productoID)) {
                producto1.nombreInventario = producto.Nombre();
                producto1.precio = producto.Precio();
                producto1.descripcion = producto.Descripcion();
                producto1.cantidad = producto.Cantidad();
                return producto1;
            }
        }
        crearProductoEnOrden(productoID, nombreInventario, precio, descripcion, cantidad);
        for (Producto producto3 : productosOrden) {
            if (producto3.entityId.equals(productoID)) {
                producto2.nombreInventario = producto3.Nombre();
                producto2.precio = producto3.Precio();
                producto2.descripcion = producto3.Descripcion();
                producto2.cantidad = producto3.Cantidad();
            }
        }
        return producto2;
    }*/

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