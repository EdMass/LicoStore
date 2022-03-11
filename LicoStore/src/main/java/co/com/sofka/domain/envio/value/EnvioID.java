package co.com.sofka.domain.envio.value;

import co.com.sofka.domain.generic.Identity;

public class EnvioID extends Identity {
    private  EnvioID (String valor){
        super(valor);
    }

    public EnvioID (){

    }
    public static EnvioID of(String valor) {

        return new EnvioID (valor);
    }
}