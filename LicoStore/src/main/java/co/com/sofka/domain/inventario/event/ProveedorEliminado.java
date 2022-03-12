package co.com.sofka.domain.inventario.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.ProveedorID;

public class ProveedorEliminado extends DomainEvent {

    private final ProveedorID proveedorID;

    public ProveedorEliminado(ProveedorID proveedorID) {
        super("");
        this.proveedorID = proveedorID;
    }

    public ProveedorID getProveedorID() {
        return proveedorID;
    }
}
