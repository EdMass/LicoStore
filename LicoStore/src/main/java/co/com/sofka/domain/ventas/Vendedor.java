package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;
import co.com.sofka.domain.ventas.value.VendedorID;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Entity<VendedorID> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected VendedorID vendedorID;


    public Vendedor(VendedorID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Vendedor(VendedorID entityId) {
        super(entityId);
    }



    public Nombre Nombre() {
        return nombre;
    }

    public Telefono Telefono() {
        return telefono;
    }

    public VendedorID VendedorID(){
        return vendedorID;
    }


}
