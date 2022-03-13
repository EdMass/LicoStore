package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.CalcularTotal;


public class CalcularTotalUseCase extends UseCase<RequestCommand<CalcularTotal>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CalcularTotal> input) {
        var command = input.getCommand();
        var venta= Venta.from(command.getVentaID(),retrieveEvents());
        venta.calcularTotal(command.getTotal());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
