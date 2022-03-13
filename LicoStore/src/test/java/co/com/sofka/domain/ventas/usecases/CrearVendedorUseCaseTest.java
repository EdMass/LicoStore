package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.comandos.CrearVendedor;
import co.com.sofka.domain.ventas.event.OrdenCreada;
import co.com.sofka.domain.ventas.event.VendedorCreado;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearVendedorUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void CrearVendedor() {
        //arrange
        VentaID ventaID = VentaID.of("xxxx");
        VendedorID vendedorID = VendedorID.of("1127");
        Nombre nombre = new Nombre("Gochi","Rojas");
        Telefono telefono = new Telefono("6563941");

        var command = new CrearVendedor(ventaID,vendedorID,nombre,telefono);
        var usecase = new CrearVendedorUseCase();


        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (VendedorCreado) events.get(0);
        Assertions.assertEquals("sofka.venta.vendedorcreado", event.type);
        Assertions.assertEquals("1127", event.getVendedorID().value());
        Assertions.assertEquals("Gochi Rojas", event.getNombre().value());

    }

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(VentaID.of("xxxx"),null),
                new OrdenCreada(OrdenID.of("ffff"))
        );
    }
}