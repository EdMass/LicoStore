package co.com.sofka.domain.envio;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.envio.value.DestinatarioID;
import co.com.sofka.domain.envio.value.Telefono;
import co.com.sofka.domain.envio.value.Nombre;
import co.com.sofka.domain.envio.value.Direccion;

public class Destinatario extends Entity<DestinatarioID> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Direccion direccion;


    public Destinatario (DestinatarioID entityId, Nombre nombre,Telefono telefono, Direccion direccion) {
        super(entityId);
        this.nombre = nombre;
        this.telefono= telefono;
        this.direccion= direccion;

    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Direccion direccion() {
        return direccion;
    }

}