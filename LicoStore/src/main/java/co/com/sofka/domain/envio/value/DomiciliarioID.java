package co.com.sofka.domain.envio.value;

import co.com.sofka.domain.generic.Identity;

public class DomiciliarioID extends Identity {
    private DomiciliarioID (String valor){
        super(valor);
    }

    public DomiciliarioID (){

    }
    public static DomiciliarioID of(String valor) {

        return new DomiciliarioID (valor);
    }
}