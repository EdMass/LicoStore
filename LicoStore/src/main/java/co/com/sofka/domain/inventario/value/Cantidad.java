package co.com.sofka.domain.inventario.value;

import co.com.sofka.domain.generic.ValueObject;

public class Cantidad implements ValueObject<Integer> {
     private Integer cantidad;

    public Cantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    private Integer getCantidad() {
        return cantidad;
    }


    @Override
    public Integer value() {
        return this.getCantidad();
    }
}
