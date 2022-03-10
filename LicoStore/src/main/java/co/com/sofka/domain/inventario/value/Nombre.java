package co.com.sofka.domain.inventario.value;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<String> {

    private final String nombre;


    public Nombre(String nombreProducto) {
        this.nombre = nombreProducto;

    }

    @Override
    public String value() {
        return nombre;
    }
}