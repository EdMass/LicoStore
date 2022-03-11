package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;
import co.com.sofka.domain.ventas.value.VendedorID;
import co.com.sofka.domain.ventas.value.VentaID;

public class VentaCreada extends DomainEvent {
    protected Nombre nombreCliente;
    protected VendedorID vendedorID;
    protected Telefono telefonoCliente;

    public VentaCreada(Nombre nombreCliente,
                       Telefono telefonoCliente,
                       VendedorID vendedorID) {
        super("sofka.venta.ventacreada");
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.vendedorID = vendedorID;
    }

    public Nombre getNombreCliente() {
        return nombreCliente;
    }

    public Telefono getTelefonoCliente() {
        return telefonoCliente;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}
