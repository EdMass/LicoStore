package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.Identity;

public class VendedorID extends Identity {
    private VendedorID(String valor){
        super(valor);
    }

    public VendedorID(){

    }
    public static VendedorID of(String valor) {

        return new VendedorID(valor);
    }
}