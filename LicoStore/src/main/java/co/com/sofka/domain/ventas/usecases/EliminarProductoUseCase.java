package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.EliminarProducto;

public class EliminarProductoUseCase extends UseCase<RequestCommand<EliminarProducto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarProducto> input) {

        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.eliminarProducto(command.getProductoID());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
