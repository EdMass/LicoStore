package co.com.sofka.domain.inventario;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.value.NombreInventario;
import co.com.sofka.domain.inventario.value.ProveedorID;
import co.com.sofka.domain.inventario.value.Telefono;

import java.util.List;


public class Proveedor extends Entity<ProveedorID> {

    protected NombreInventario nombreInventario;
    protected Telefono telefono;
    protected List<Producto> productos;

    public Proveedor(ProveedorID entityId, NombreInventario nombreInventario, Telefono telefono, List<Producto> productos) {
        super(entityId);
        this.nombreInventario = nombreInventario;
        this.telefono = telefono;
        this.productos = productos;
    }

    public NombreInventario nombre() {
        return nombreInventario;
    }

    public Telefono telefono() {
        return telefono;
    }

    public List<Producto> Productos() {
        return productos;
    }
}