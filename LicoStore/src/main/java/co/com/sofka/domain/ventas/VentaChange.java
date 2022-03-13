package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.ventas.comandos.GenerarFactura;
import co.com.sofka.domain.ventas.event.*;
import co.com.sofka.domain.ventas.value.Factura;
import co.com.sofka.domain.ventas.value.Pago;
import co.com.sofka.domain.ventas.value.Total;

public class VentaChange extends EventChange {


    public VentaChange(Venta venta) {


        apply((VentaCreada event) -> {
            venta.fecha = event.getFecha();
        });


        apply((VendedorCambiado event) -> {
            var vendedorActualizado = new Vendedor(event.getVendedorID(),event.getNombre(), event.getTelefono());
            venta.vendedor = vendedorActualizado;
        });

        apply((ClienteActualizado event) -> {

            venta.actualizarCliente(event.getClienteID(), event.getNombre(), event.getTelefono());

        });

        apply((ProductoAgregado event) -> {
            venta.orden.agregarProductoAOrden(
                    event.getProductoID(),
                    event.getNombreProducto(),
                    event.getPrecio(),
                    event.getDescripcion(),
                    event.getCantidad());
        });

        apply((VendedorCreado event) -> {
            venta.crearVendedor(event.getVendedorID(), event.getNombre(), event.getTelefono());
        });

        apply((ClienteCreado event) -> {
            venta.crearCliente(event.getClienteID(), event.getNombre(), event.getTelefono());

        });

        apply((ClienteAsignado event) -> {
            venta.cliente = new Cliente(event.getClienteID(), event.getNombre(), event.getTelefono());
        });

        apply((VendedorAsignado event) -> {
            venta.vendedor = new Vendedor(event.getVendedorID(), event.getNombre(), event.getTelefono());
        });

        apply((ProductoEliminado event) -> {
            venta.orden.eliminarProducto(event.getProductoID());
        });

        apply((FacturaGenerada event) -> {
            venta.factura= event.getFactura();
        });

        apply((TotalCalculado event) -> {
            venta.total = new Total(venta.Orden().identity());
        });

        apply((VentaPagada event) -> {
            venta.pago = new Pago(Pago.Fase.PAGADO);
        });

        apply((OrdenCreada event) -> {
            venta.orden = new Orden(event.getOrdenID());
        });
    }

}
