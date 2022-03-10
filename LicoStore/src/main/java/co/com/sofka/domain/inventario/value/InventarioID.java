package co.com.sofka.domain.inventario.value;

import co.com.sofka.domain.generic.Identity;

public class InventarioID extends Identity {
    private InventarioID (String valor){
        super(valor);
    }

    public InventarioID (){

    }
    public static InventarioID of(String valor) {

        return new InventarioID (valor);
    }
}
