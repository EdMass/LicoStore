package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.ventas.Orden;

public class Total implements ValueObject<Double> {

    private Double contador = 0.0;
    private final OrdenID ordenID;

    public Total(OrdenID ordenID) {
        this.ordenID = ordenID;
    }

    public Double sumarProductos(){
         Orden orden = new Orden(ordenID);
        for (Producto producto: orden.listarProductos()) {
            contador = contador + producto.precio().getPrice();
        }
        return contador;
    }

    @Override
    public Double value() {
        return this.sumarProductos();
    }

}
