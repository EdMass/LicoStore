package co.com.sofka.domain.inventario;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.value.Nombre;
import co.com.sofka.domain.inventario.value.ProveedorID;
import co.com.sofka.domain.inventario.value.Telefono;

import java.util.List;


public class Proveedor extends Entity<ProveedorID> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected List<Producto> productos;

    public Proveedor(ProveedorID entityId, Nombre nombre, Telefono telefono, List<Producto> productos) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.productos = productos;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public List<Producto> Productos() {
        return productos;
    }
}