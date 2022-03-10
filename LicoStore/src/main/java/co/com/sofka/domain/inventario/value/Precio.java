package co.com.sofka.domain.inventario.value;

import co.com.sofka.domain.generic.ValueObject;

public class Precio  implements ValueObject<Double> {

    private Double price;

    public Precio(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public Double value() {
        return this.price;
    }
}