package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.CambiarVendedor;

public class CambiarVendedorUseCase extends UseCase<RequestCommand<CambiarVendedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarVendedor> input) {
        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.cambiarVendedor(
                command.getVendedorID());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
