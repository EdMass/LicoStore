package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.ventas.event.*;
import co.com.sofka.domain.ventas.value.Factura;
import co.com.sofka.domain.ventas.value.Total;

public class VentaChange extends EventChange {


    public VentaChange(Venta venta) {


        apply((VentaCreada event) -> {
            venta.vendedorID = event.getVendedorID();
            venta.clienteID = event.getClienteID();
            venta.fecha =event.getFecha();
        });


        apply((VendedorCambiado event) -> {
            Vendedor vendedor = new Vendedor(event.getVendedorID());
            var vendedorActualizado = vendedor.buscarVendedorPorID(event.getVendedorID());
            venta.vendedorID = vendedorActualizado.VendedorID();
        });

        apply((ClienteActualizado event) -> {
            Cliente cliente = new Cliente(event.getClienteID(), event.getNombre(), event.getTelefono());
            cliente.actualizarCliente(cliente.identity(),
                    cliente.Nombre(), cliente.Telefono());


        });

        apply((ProductoAgregado event) -> {
            venta.orden.agregarProductoAOrden(event.getProductoID(),
                    event.getNombreProducto(),
                    event.getPrecio(),
                    event.getDescripcion(),
                    event.getCantidad());
        });

        apply((VendedorCreado event) -> {
            Vendedor vendedor = new Vendedor(event.getVendedorID());
            vendedor.crearVendedor(event.getVendedorID(), event.getNombre(), event.getTelefono());
        });

        apply((ClienteCreado event) -> {
            Cliente cliente = new Cliente(event.getClienteID());
            cliente.crearCliente(event.getClienteID(), event.getNombre(), event.getTelefono());
        });

        apply((ClienteAsignado event) -> {
           venta.clienteID = event.getClienteID();
        });

        apply((VendedorAsignado event) -> {
            venta.vendedorID = event.getVendedorID();
        });

        apply((ProductoEliminado event) -> {
            venta.orden.eliminarProducto(event.getProductoID());
        });

        apply((FacturaGenerada event) -> {
            Factura factura = new Factura(venta.Fecha(),
                    venta.Pago(), venta.Orden(),
                    venta.VendedorID(), venta.Total());
        });

        apply((TotalCalculado event) -> {
            venta.total = new Total(venta.Orden().identity());
        });

        apply((VentaPagada event) -> {
            venta.pago = event.getPago();
        });
    }

}
