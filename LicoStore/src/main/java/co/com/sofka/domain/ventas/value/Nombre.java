package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<String> {

    private final String nombre;
    private final String apellido;


    public Nombre(String primerNombre, String apellido) {
        this.nombre = primerNombre;
        this.apellido = apellido;
    }

    @Override
    public String value() {
        return nombre + " " + apellido;
    }

}
