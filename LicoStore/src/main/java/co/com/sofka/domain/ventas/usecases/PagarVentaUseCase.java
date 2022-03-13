package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.PagarVenta;

public class PagarVentaUseCase extends UseCase<RequestCommand<PagarVenta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<PagarVenta> input) {
        var command = input.getCommand();
        var venta= Venta.from(command.getVentaID(),retrieveEvents());
        venta.pagarVenta(command.getPago());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
