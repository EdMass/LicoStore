package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.value.*;

public class VentaCreada extends DomainEvent {
    private final Nombre nombreCliente;
    private final VendedorID vendedorID;
    private final Telefono telefonoCliente;
    private final ClienteID clienteID;

    public VentaCreada(ClienteID clienteID,Nombre nombreCliente,
                       Telefono telefonoCliente,
                       VendedorID vendedorID) {
        super("sofka.venta.ventacreada");
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.vendedorID = vendedorID;
        this.clienteID = clienteID;
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

    public ClienteID getClienteID() {
        return clienteID;
    }
}
