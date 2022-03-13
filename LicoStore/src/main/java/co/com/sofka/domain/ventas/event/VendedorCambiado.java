package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;
import co.com.sofka.domain.ventas.value.VendedorID;

public class VendedorCambiado extends DomainEvent {

    private final VendedorID vendedorID;
    private final Nombre nombre;
    private final Telefono telefono;

    public VendedorCambiado(VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        super("sofka.venta.vendedorcambiado");
        this.vendedorID =vendedorID;
        this.nombre=nombre;
        this.telefono=telefono;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
