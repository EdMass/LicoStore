package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.inventario.value.Nombre;
import co.com.sofka.domain.inventario.value.ProveedorID;

import java.util.List;

public class ProveedorCreado extends DomainEvent {

    private final ProveedorID proveedorID;
    private final Nombre nombre;
    private final List<Producto> productos;

    public ProveedorCreado(ProveedorID proveedorID, Nombre nombre, List<Producto> productos) {
        super("sofka.inventario.proveedorcreado");
        this.proveedorID = proveedorID;
        this.nombre = nombre;
        this.productos = productos;
    }

    public ProveedorID getProveedorID() {
        return proveedorID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
