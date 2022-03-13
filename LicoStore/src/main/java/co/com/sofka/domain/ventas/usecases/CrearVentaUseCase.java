package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.CrearVenta;


public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVenta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearVenta> input) {
        var command= input.getCommand();
        var Venta = new Venta(command.getVentaID(), command.getFecha());
        emit().onResponse(new ResponseEvents(Venta.getUncommittedChanges()));
    }
}
