package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.ValueObject;

public class Pago implements ValueObject<Pago.Fase> {
    private final Fase value;

    public Pago(Fase value) {
        this.value = value;
    }

    @Override
    public Fase value() {
        return value;
    }

    public enum Fase {
        PAGADO, NO_PAGADO
    }
}
