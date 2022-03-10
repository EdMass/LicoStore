package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.Identity;

public class ClienteID extends Identity {
    private ClienteID(String valor){
        super(valor);
    }

    public ClienteID(){
        
    }
    public static ClienteID of(String valor) {
        
        return new ClienteID(valor);
    }
}
