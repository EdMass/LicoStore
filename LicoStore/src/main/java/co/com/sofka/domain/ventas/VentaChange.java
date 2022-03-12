package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.ventas.event.ClienteActualizado;
import co.com.sofka.domain.ventas.event.VendedorCambiado;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.VendedorID;

import java.util.List;

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
            venta.vendedorID = vendedorActualizado.vendedorID();
        });

        apply((ClienteActualizado event) -> {
            Cliente cliente = new Cliente(event.getClienteID(), event.getNombre(), event.getTelefono());
            cliente.actualizarCliente(cliente.identity(),
                    cliente.Nombre(), cliente.Telefono());


        });
/*
        apply((ProductoAgregado event) -> {
            venta. =
        });
    }

    private Cliente getClienteByIdentity(Venta entity, Identity identity) {
        return entity.students.stream()
                .filter(e -> e.identity().equals(identity))
                .findFirst()
                .orElseThrow();
    }*/
    }
}
