package co.com.sofka.domain.inventario.value;

import co.com.sofka.domain.generic.Identity;

public class ProveedorID extends Identity {
    private ProveedorID (String valor){
        super(valor);
    }

    public ProveedorID (){

    }
    public static ProveedorID of(String valor) {

        return new ProveedorID (valor);
    }
}