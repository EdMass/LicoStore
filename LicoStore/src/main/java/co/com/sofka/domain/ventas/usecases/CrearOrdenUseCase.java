package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.CrearOrden;

public class CrearOrdenUseCase extends UseCase<RequestCommand<CrearOrden>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearOrden> input) {

        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.crearOrden(command.getOrdenID());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }

}
