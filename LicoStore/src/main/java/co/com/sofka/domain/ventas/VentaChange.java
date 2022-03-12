package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.ventas.event.ClienteActualizado;
import co.com.sofka.domain.ventas.event.ProductoAgregado;
import co.com.sofka.domain.ventas.event.VendedorCambiado;
import co.com.sofka.domain.ventas.event.VentaCreada;

public class VentaChange extends EventChange {


    public VentaChange(Venta venta) {


        apply((VentaCreada event) -> {
            venta.vendedorID = event.getVendedorID();
            venta.clienteID = event.getClienteID();
            venta.factura = event.getFactura();
            venta.fecha = event.getFecha();
            venta.orden = event.getOrden();
            venta.total = event.getTotal();
            venta.pago = event.getPago();
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


    }

}
