package co.com.sofka.domain.inventario.value;

import co.com.sofka.domain.generic.ValueObject;

public class NombreInventario implements ValueObject<String> {

    private final String nombre;


    public NombreInventario(String nombreProducto) {
        this.nombre = nombreProducto;

    }

    @Override
    public String value() {
        return nombre;
    }
}