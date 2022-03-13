package co.com.sofka.domain.ventas.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.event.ProductoCreado;
import co.com.sofka.domain.inventario.event.ProductoEliminado;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.comandos.AgregarProductoAOrden;
import co.com.sofka.domain.ventas.comandos.EliminarProducto;
import co.com.sofka.domain.ventas.event.OrdenCreada;
import co.com.sofka.domain.ventas.event.ProductoAgregado;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.OrdenID;
import co.com.sofka.domain.ventas.value.VentaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class EliminarProductoUseCaseTest {

    @Mock
    private DomainEventRepository repository;
@Test
    void EliminarProducto(){
    VentaID ventaID = VentaID.of("xxxx");
    ProductoID productoID = ProductoID.of("ffffff");




    var command = new EliminarProducto(ventaID,productoID);

    var usecase = new EliminarProductoUseCase();

    Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
    usecase.addRepository(repository);


    var events = UseCaseHandler.getInstance()
            .setIdentifyExecutor(ventaID.value())
            .syncExecutor(usecase, new RequestCommand<>(command))
            .orElseThrow()
            .getDomainEvents();

    var event = (ProductoEliminado) events.get(events.size()-1);
    Assertions.assertEquals("sofka.inventario.productoeliminado", event.type);
    Assertions.assertEquals("ffffff", event.getProductoID().value());


}

    private List<DomainEvent> history() {
        return List.of(
                new VentaCreada(VentaID.of("xxxx"),null),
                new OrdenCreada(OrdenID.of("234")),
                new ProductoCreado(ProductoID.of("ffffff"), new NombreInventario("gin"), new Precio(80.0),new Descripcion("Licor fuerte")),
                new ProductoAgregado(ProductoID.of("ffffff"), new NombreInventario("gin"),new Precio(80.0),new Descripcion("Licor fuerte"),new Cantidad(3))


        );
    }

}