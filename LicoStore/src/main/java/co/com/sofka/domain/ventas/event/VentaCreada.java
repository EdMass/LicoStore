package co.com.sofka.domain.ventas.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.Orden;
import co.com.sofka.domain.ventas.value.*;

public class VentaCreada extends DomainEvent {

    private final ClienteID clienteID;
    private final VendedorID vendedorID;
    private final Fecha fecha;
    private final Pago pago;
    private final Orden orden;
    private final Factura factura;
    private final Total total;


    public VentaCreada(ClienteID clienteID,
                       VendedorID vendedorID, Fecha fecha, Pago pago,
                       Orden orden, Factura factura, Total total) {
        super("sofka.venta.ventacreada");

        this.vendedorID = vendedorID;
        this.clienteID = clienteID;
        this.fecha= fecha;
        this.pago=pago;
        this.orden= orden;
        this.factura= factura;
        this.total=total;

    }

    public Fecha getFecha() {
        return fecha;
    }

    public Pago getPago() {
        return pago;
    }

    public Orden getOrden() {
        return orden;
    }

    public Factura getFactura() {
        return factura;
    }

    public Total getTotal() {
        return total;
    }



    public VendedorID getVendedorID() {
        return vendedorID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }
}
