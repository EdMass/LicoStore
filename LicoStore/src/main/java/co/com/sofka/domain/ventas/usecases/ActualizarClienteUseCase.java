package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.ActualizarCliente;

public class ActualizarClienteUseCase extends UseCase<RequestCommand<ActualizarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCliente> input) {
        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.actualizarCliente(
                command.getClienteID(),
                command.getNombre(),
                command.getTelefono());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
