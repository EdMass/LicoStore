package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.InventarioID;

public class InventarioCreado extends DomainEvent {

    public InventarioCreado() {
        super("sofka.inventario.inventariocreado");
    }
}
