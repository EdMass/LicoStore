package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.ValueObject;

public class Pago implements ValueObject<Double> {

    private Double dinero;
    private Total total;

    public Pago(Double dinero, Total total) {
        this.dinero = dinero;
        this.total = total;
    }

    public Double vueltos(Double dinero, Total total){
        dinero= dinero - total.value();
            return dinero;
    }

    @Override
    public Double value() {
        return dinero;
    }
}
