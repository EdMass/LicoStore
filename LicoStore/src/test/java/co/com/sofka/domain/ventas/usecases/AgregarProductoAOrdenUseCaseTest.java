package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.comandos.AgregarProductoAOrden;
import co.com.sofka.domain.ventas.event.ProductoAgregado;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.Fecha;
import co.com.sofka.domain.ventas.value.VentaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarProductoAOrdenUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarProducto(){
        //arrange
        VentaID ventaID = VentaID.of("xxxx");
        ProductoID productoID = ProductoID.of("ffffff");
        NombreInventario nombre = new NombreInventario("Caja de cereales");
        Precio precio = new Precio(50.52);
        Descripcion descripcion = new Descripcion("Contiene trozitos ricos ");
        Cantidad cantidad = new Cantidad(5);


        var command = new AgregarProductoAOrden(ventaID,productoID,nombre,precio,descripcion,cantidad);

        var usecase = new AgregarProductoAOrdenUseCase();


        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert

        var event = (ProductoAgregado) events.get(0);
        Assertions.assertEquals("sofka.venta.productoagregago", event.type);
        Assertions.assertEquals("Caja de cereales", event.getNombreProducto().value());
        Assertions.assertEquals("ffffff", event.getProductoID().value());

    }

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(VentaID.of("xxxx"),null)
        );    }
}