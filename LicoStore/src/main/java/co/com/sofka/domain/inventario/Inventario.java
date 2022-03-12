package co.com.sofka.domain.inventario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.event.*;
import co.com.sofka.domain.inventario.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Inventario extends AggregateEvent {

    protected Set<Producto> productos;
    protected Set<Proveedor> proveedores;

    public Inventario(InventarioID inventarioID) {
        super(inventarioID);
        subscribe(new InventarioChange(this));
        appendChange(new InventarioCreado()).apply();
    }

    public static Inventario from(InventarioID entityId, List<DomainEvent> list) {
        Inventario inventario = new Inventario(entityId);
        list.forEach(inventario::applyEvent);
        return inventario;
    }

    public void crearProducto(ProductoID productoID,
                              NombreInventario nombreInventario,
                              Precio precio,
                              Descripcion descripcion,
                              ProveedorID proveedorID){
        Objects.requireNonNull(productoID);
        Objects.requireNonNull(nombreInventario);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(descripcion);
        appendChange(new ProductoCreado(productoID, nombreInventario, precio, descripcion)).apply();
    }

    public void eliminarProducto(ProductoID productoID){
        Objects.requireNonNull(productoID);
        appendChange(new ProductoEliminado(productoID)).apply();
    }

    public void crearProveedor(ProveedorID proveedorID, NombreInventario nombreInventario, List<Producto> productos ){
        Objects.requireNonNull(proveedorID);
        Objects.requireNonNull(nombreInventario);
        Objects.requireNonNull(productos);
        appendChange(new ProveedorCreado(proveedorID, nombreInventario, productos)).apply();
    }

    public void eliminarProveedor(ProveedorID proveedorID){
        Objects.requireNonNull(proveedorID);
        appendChange(new ProveedorEliminado(proveedorID)).apply();
    }

    public void actualizarDescripciondeProducto(ProductoID productoID, Descripcion newDescripcion){
        Objects.requireNonNull(productoID);
        Objects.requireNonNull(newDescripcion);
        appendChange(new DescripciondeProductoActualizada(productoID, newDescripcion)).apply();
    }

    public void modificarPrecioProducto(ProductoID productoID, Precio precio){
        Objects.requireNonNull(productoID);
        Objects.requireNonNull(precio);
        appendChange(new precioProductoModificado(productoID, precio)).apply();
    }

    public Set<Producto> Productos() {
        return productos;
    }

    public Set<Proveedor> Proveedores() {
        return proveedores;
    }
}
