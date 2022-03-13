package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.comandos.AsignarCliente;
import co.com.sofka.domain.ventas.event.*;
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
class AsignarClienteUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void AsignarCliente(){
        //arrange
        VentaID ventaID = VentaID.of("xxxx");
        ClienteID clienteID= ClienteID.of("1230");
        Nombre nombre= new Nombre("Edwar", "Mass");
        Telefono telefono= new Telefono("6563941");

        var command = new AsignarCliente(ventaID, clienteID, nombre, telefono);

        var usecase = new AsignarClienteUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ClienteAsignado) events.get(0);
        Assertions.assertEquals("sofka.venta.clienteasignado", event.type);
        Assertions.assertEquals("1230",event.getClienteID().value());
        Assertions.assertEquals("6563941", event.getTelefono().value());
    }
    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(VentaID.of("xxxx"),null),
                new OrdenCreada(OrdenID.of("ffff")),
                new ClienteCreado(ClienteID.of("gggg"),null,null)
        );
    }
}