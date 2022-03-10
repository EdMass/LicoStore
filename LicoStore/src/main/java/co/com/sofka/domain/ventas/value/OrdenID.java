package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.Identity;

public class OrdenID extends Identity {
    private OrdenID(String valor){
        super(valor);
    }

    public OrdenID(){

    }
    public static OrdenID of(String valor) {

        return new OrdenID(valor);
    }
}