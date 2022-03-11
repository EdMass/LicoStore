package co.com.sofka.domain.inventario;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.inventario.event.InventarioCreado;
import co.com.sofka.domain.inventario.value.InventarioID;

import java.util.Set;

public class Inventario extends AggregateEvent {

    protected Set<Producto> productos;
    protected Set<Proveedor> proveedores;

    public Inventario(InventarioID inventarioID) {
        super(inventarioID);
        subscribe(new InventarioChange(this));
        appendChange(new InventarioCreado()).apply();
    }


}
