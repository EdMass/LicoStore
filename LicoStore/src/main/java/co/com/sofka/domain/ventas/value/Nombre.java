package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.ValueObject;

public class Nombre implements ValueObject<String> {

    private final String nombre;
    private final String apellido;


    public Nombre(String primerNombre, String segundoNombre) {
        this.nombre = primerNombre;
        this.apellido = segundoNombre;
    }

    @Override
    public String value() {
        return nombre + " " + apellido;
    }

}
