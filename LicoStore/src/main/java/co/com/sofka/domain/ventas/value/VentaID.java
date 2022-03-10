package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.Identity;

public class VentaID extends Identity {
    private VentaID(String valor){
        super(valor);
    }

    public VentaID(){

    }
    public static VentaID of(String valor) {

        return new VentaID(valor);
    }
}