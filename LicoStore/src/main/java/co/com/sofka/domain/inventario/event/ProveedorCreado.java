package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.inventario.value.NombreInventario;
import co.com.sofka.domain.inventario.value.ProveedorID;

import java.util.List;

public class ProveedorCreado extends DomainEvent {

    private final ProveedorID proveedorID;
    private final NombreInventario nombreInventario;
    private final List<Producto> productos;

    public ProveedorCreado(ProveedorID proveedorID, NombreInventario nombreInventario, List<Producto> productos) {
        super("sofka.inventario.proveedorcreado");
        this.proveedorID = proveedorID;
        this.nombreInventario = nombreInventario;
        this.productos = productos;
    }

    public ProveedorID getProveedorID() {
        return proveedorID;
    }

    public NombreInventario getNombre() {
        return nombreInventario;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
