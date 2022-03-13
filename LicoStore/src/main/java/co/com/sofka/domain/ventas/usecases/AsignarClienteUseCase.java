package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.AsignarCliente;

public class AsignarClienteUseCase extends UseCase<RequestCommand<AsignarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarCliente> input) {

        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.asignarCliente(command.getClienteID());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
