package co.com.sofka.domain.ventas;



import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.ventas.event.VentaCreada;
import co.com.sofka.domain.ventas.value.*;

import java.lang.annotation.Annotation;


public class Venta extends AggregateEvent<VentaID> {

    protected Cliente cliente;
    protected Fecha fecha;
    protected Pago pago;
    protected Orden orden;
    protected VendedorID vendedorID;
    protected EnvioID envioID;


    public Venta(VentaID entityId, Cliente cliente, VendedorID vendedorID) {
        super(entityId);
        this.cliente = cliente;
        this.vendedorID = vendedorID;
        appendChange(new VentaCreada(cliente, vendedorID)).apply();
    }


}
