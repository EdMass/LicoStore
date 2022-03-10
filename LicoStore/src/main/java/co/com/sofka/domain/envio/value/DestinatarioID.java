package co.com.sofka.domain.envio.value;

import co.com.sofka.domain.generic.Identity;

public class DestinatarioID extends Identity {
    private DestinatarioID (String valor){
        super(valor);
    }

    public DestinatarioID (){

    }
    public static DestinatarioID of(String valor) {

        return new DestinatarioID (valor);
    }
}