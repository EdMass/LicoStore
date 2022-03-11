package co.com.sofka.domain.ventas.value;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.Orden;

public class Factura implements ValueObject<String> {

    private Nombre nombre;
    private Fecha fecha;
    private Pago pago;
    private Orden orden;
    private VendedorID vendedorID;
    private Total total;


    public Factura(Nombre nombre, Fecha fecha, Pago pago, Orden orden, VendedorID vendedorID, Total total) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.pago = pago;
        this.orden = orden;
        this.vendedorID = vendedorID;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Nombre=" + nombre +
                ", fecha=" + fecha +
                ", pago=" + pago +
                ", orden=" + orden +
                ", vendedorID=" + vendedorID +
                ", total=" + total +
                '}';
    }

    @Override
    public String value() {
        return this.toString();
    }
}
