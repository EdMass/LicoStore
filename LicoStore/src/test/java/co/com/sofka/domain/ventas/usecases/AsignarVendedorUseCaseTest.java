package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.comandos.AsignarCliente;
import co.com.sofka.domain.ventas.comandos.AsignarVendedor;
import co.com.sofka.domain.ventas.event.*;
import co.com.sofka.domain.ventas.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AsignarVendedorUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    @Test
    void AsignarVendedor(){
        VentaID ventaID = VentaID.of("xxxx");
        VendedorID vendedorID= VendedorID.of("1230");
        Nombre nombre= new Nombre("Edward", "Cullen");
        Telefono telefono= new Telefono("2342397");

        var command = new AsignarVendedor(ventaID, vendedorID, nombre, telefono);

        var usecase = new AsignarVendedorUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (VendedorAsignado) events.get(0);
        Assertions.assertEquals("sofka.venta.vendedorasignado", event.type);
        Assertions.assertEquals("1230",event.getVendedorID().value());
        Assertions.assertEquals("2342397", event.getTelefono().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(VentaID.of("xxxx"),null),
                new OrdenCreada(OrdenID.of("ffff")),
                new VendedorCreado(VendedorID.of("gggg"),null,null)
        );
    }

}