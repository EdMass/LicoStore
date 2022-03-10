package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.value.VendedorID;

public class VentaCreada extends DomainEvent {
    protected Cliente cliente;
    protected VendedorID vendedorID;

    public VentaCreada(Cliente cliente, VendedorID vendedorID) {
        super("sofka.venta.ventacreada");
        this.cliente = cliente;
        this.vendedorID = vendedorID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public VendedorID getVendedorID() {
        return vendedorID;
    }
}
