package co.com.sofka.domain.envio;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.envio.value.DomiciliarioID;
import co.com.sofka.domain.inventario.value.Telefono;
import co.com.sofka.domain.inventario.value.Nombre;

public class Domiciliario extends Entity<DomiciliarioID> {

    protected Nombre nombre;
    protected Telefono telefono;


    public Domiciliario (DomiciliarioID entityId, Nombre nombre,Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono= telefono;

    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

}
