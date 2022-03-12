package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.ventas.event.ClienteActualizado;
import co.com.sofka.domain.ventas.event.VendedorCambiado;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.ClienteID;
import java.util.List;

public class VentaChange extends EventChange {


    public VentaChange(Venta venta) {
    /*

        apply((VentaCreada event) -> {
            venta.vendedorID = event.getVendedorID();
            venta.cliente = event.getCliente();
        });

        apply((VendedorCambiado event) ->{
            venta.vendedorID = event.getVendedorID();
        });

        apply((ClienteActualizado event) -> {
            venta.cliente.actualizarCliente(event.getCliente().getClienteID(),
                                            event.getCliente().nombre,
                                            event.getCliente().telefono);
        });

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
