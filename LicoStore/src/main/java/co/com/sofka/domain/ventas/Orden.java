package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.OrdenID;

public class Orden extends Entity<OrdenID> {


    public Orden(OrdenID entityId) {
        super(entityId);
    }
}
