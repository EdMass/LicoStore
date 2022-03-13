package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.ProductoID;
import co.com.sofka.domain.ventas.comandos.AgregarProductoAOrden;
import co.com.sofka.domain.ventas.comandos.CrearOrden;
import co.com.sofka.domain.ventas.event.OrdenCreada;
import co.com.sofka.domain.ventas.event.ProductoAgregado;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.OrdenID;
import co.com.sofka.domain.ventas.value.VentaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearOrdenUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void CrearOrden() {
        //arrange
        VentaID ventaID = VentaID.of("xxxx");
        OrdenID ordenID = OrdenID.of("5230");

        var command = new CrearOrden(ventaID, ordenID);
        var usecase = new CrearOrdenUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (OrdenCreada) events.get(0);
        Assertions.assertEquals("sofka.venta.ordencreada", event.type);
        Assertions.assertEquals("5230", event.getOrdenID().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(VentaID.of("xxxx"), null)
        );
    }
}