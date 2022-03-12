package co.com.sofka.domain.inventario;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.event.InventarioCreado;
import co.com.sofka.domain.inventario.event.ProductoCreado;
import co.com.sofka.domain.inventario.event.ProductoEliminado;
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
                              Nombre nombre,
                              Precio precio,
                              Descripcion descripcion){
        Objects.requireNonNull(productoID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(descripcion);
        appendChange(new ProductoCreado(productoID, nombre, precio, descripcion)).apply();
    }

    public void eliminarProducto(ProductoID productoID){
        Objects.requireNonNull(productoID);
        appendChange(new ProductoEliminado(productoID)).apply();
    }

    public void crearProveedor(){

    }
}
