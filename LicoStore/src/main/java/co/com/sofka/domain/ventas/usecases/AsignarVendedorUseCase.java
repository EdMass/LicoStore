package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.ventas.Venta;
import co.com.sofka.domain.ventas.comandos.AsignarVendedor;

public class AsignarVendedorUseCase extends UseCase<RequestCommand<AsignarVendedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarVendedor> input) {

        var command = input.getCommand();
        var venta = Venta.from(command.getVentaID(), retrieveEvents());
        venta.asignarVendedor(
                command.getVendedorID(),
                command.getNombre(),
                command.getTelefono());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
