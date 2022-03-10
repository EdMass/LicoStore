package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;

public class Cliente extends Entity<ClienteID> {

    protected Nombre nombre;
    protected Telefono telefono;

    public Cliente(ClienteID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }
}
