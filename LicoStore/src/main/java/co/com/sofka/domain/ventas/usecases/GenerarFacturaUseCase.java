package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.GenerarFactura;

public class GenerarFacturaUseCase extends UseCase<RequestCommand<GenerarFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarFactura> input) {

        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.generarFactura(command.getFactura());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
