package co.com.sofka.domain.ventas;

import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.event.*;
import co.com.sofka.domain.ventas.value.*;
import co.com.sofka.domain.ventas.value.Telefono;

import java.util.List;
import java.util.Objects;


public class Venta extends AggregateEvent<VentaID> {

    protected ClienteID clienteID;
    protected Fecha fecha;
    protected Pago pago;
    protected Orden orden;
    protected VendedorID vendedorID;
    protected EnvioID envioID;
    protected Total total;
    protected Factura factura;


    public Venta(VentaID entityId,
                 ClienteID clienteID,
                 VendedorID vendedorID,
                 Fecha fecha) {
        super(entityId);
        subscribe(new VentaChange(this));
        appendChange(new VentaCreada(clienteID, vendedorID, fecha)).apply();
    }

    // TODO: 11/03/2022 arreglar el VentaChange
    private Venta(VentaID entityId) {
        super(entityId);
        subscribe(new VentaChange(this));
    }

    public static Venta from(VentaID entityId, List<DomainEvent> list) {
        Venta venta = new Venta(entityId);
        list.forEach(venta::applyEvent);
        return venta;
    }

    /*todo crear el evento EnvioCreado
     public Boolean validarEnvio(Boolean hayEnvio){
        if (hayEnvio){
            appendChange(new EnvioCreado()).apply();
        }
        return null;
    }*/


    public void crearVendedor(VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(vendedorID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new VendedorCreado(vendedorID, nombre, telefono)).apply();
    }

    public void crearCliente(ClienteID clienteID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new ClienteCreado(clienteID, nombre, telefono)).apply();
    }

    public void asignarCliente(ClienteID clienteID) {
        Objects.requireNonNull(clienteID);
        appendChange((new ClienteAsignado(clienteID))).apply();
    }

    public void asignarVendedor(VendedorID vendedorID) {
        Objects.requireNonNull(vendedorID);
        appendChange(new VendedorAsignado(vendedorID)).apply();
    }

    public void cambiarVendedor(VendedorID vendedorID) {
        Objects.requireNonNull(vendedorID);
        appendChange(new VendedorCambiado(vendedorID)).apply();
    }

    public void actualizarCliente(ClienteID clienteID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(clienteID);
        appendChange(new ClienteActualizado(clienteID, nombre, telefono)).apply();
    }

    public void agregarProducto(ProductoID productoID,
                                NombreInventario nombreProducto,
                                Precio precio,
                                Descripcion descripcion,
                                Cantidad cantidad) {
        Objects.requireNonNull(productoID);
        Objects.requireNonNull(nombreProducto);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(cantidad);
        appendChange(new ProductoAgregado(productoID, nombreProducto, precio,descripcion, cantidad)).apply();
    }

    public void eliminarProducto(ProductoID productoID) {
        appendChange(new ProductoEliminado(productoID)).apply();
    }

    public void agregarVentaAVendedor(VentaID ventaID, VendedorID vendedorID) {
        Objects.requireNonNull(ventaID);
        Objects.requireNonNull(vendedorID);
        appendChange(new VentaAgregadaAVendedor(ventaID, vendedorID)).apply();
    }

    public void generarFactura(Factura factura) {
        Objects.requireNonNull(factura);
        appendChange(new FacturaGenerada(factura)).apply();
    }

    public void calcularTotal(Total total) {
        Objects.requireNonNull(total);
        appendChange(new TotalCalculado(total)).apply();
    }

    public void pagarVenta(Pago pago) {
        Objects.requireNonNull(pago);
        appendChange(new VentaPagada(pago)).apply();
    }


    public Fecha Fecha() {
        return fecha;
    }

    public Pago Pago() {
        return pago;
    }

    public Orden Orden() {
        return orden;
    }

    public EnvioID EnvioID() {
        return envioID;
    }

    public Total Total() {
        return total;
    }

    public Factura Factura() {
        return factura;
    }

    public ClienteID ClienteID() {
        return clienteID;
    }

    public VendedorID VendedorID() {
        return vendedorID;
    }
}
