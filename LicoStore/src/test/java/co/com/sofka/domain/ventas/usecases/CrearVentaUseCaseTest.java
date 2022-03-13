package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.Fecha;
import co.com.sofka.domain.ventas.comandos.CrearVenta;
import co.com.sofka.domain.ventas.value.VentaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CrearVentaUseCaseTest {

    @Test
    void CrearVenta() {
        //arrange
        VentaID ventaID = new VentaID();
        Fecha fecha = new Fecha();

        var command = new CrearVenta(ventaID, fecha);
        var usecase = new CrearVentaUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (VentaCreada) events.get(0);
        Assertions.assertEquals("sofka.venta.ventacreada", event.type);
        Assertions.assertEquals(ventaID.value(), event.aggregateRootId());
    }

}