package co.com.sofka.domain.inventario;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.value.Nombre;
import co.com.sofka.domain.inventario.value.ProveedorID;
import co.com.sofka.domain.inventario.value.Telefono;


public class Proveedor extends Entity<ProveedorID> {

    protected Nombre nombre;
    protected Telefono telefono;

    public Proveedor(ProveedorID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }
}