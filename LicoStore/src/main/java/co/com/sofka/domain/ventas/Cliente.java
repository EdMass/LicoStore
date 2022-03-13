package co.com.sofka.domain.ventas;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;

import java.util.Objects;

public class Cliente extends Entity<ClienteID> {

    protected Nombre nombre;
    protected Telefono telefono;



    public Cliente(ClienteID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(ClienteID clienteID) {
        super(clienteID);
    }





    public Telefono Telefono() {
        return telefono;
    }


    public Nombre Nombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, telefono);
    }
}
