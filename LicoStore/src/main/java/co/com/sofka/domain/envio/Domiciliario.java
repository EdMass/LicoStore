package co.com.sofka.domain.envio;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.envio.value.DomiciliarioID;
import co.com.sofka.domain.inventario.value.Telefono;
import co.com.sofka.domain.inventario.value.NombreInventario;

public class Domiciliario extends Entity<DomiciliarioID> {

    protected NombreInventario nombreInventario;
    protected Telefono telefono;


    public Domiciliario (DomiciliarioID entityId, NombreInventario nombreInventario, Telefono telefono) {
        super(entityId);
        this.nombreInventario = nombreInventario;
        this.telefono= telefono;

    }

    public NombreInventario nombre() {
        return nombreInventario;
    }

    public Telefono telefono() {
        return telefono;
    }

}
