package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.AgregarProductoAOrden;

public class AgregarProductoAOrdenUseCase extends UseCase<RequestCommand<AgregarProductoAOrden>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProductoAOrden> input) {

        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.agregarProducto(
                command.getProductoID(),
                command.getNombreInventario(),
                command.getPrecio(),
                command.getDescripcion(),
                command.getCantidad());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
