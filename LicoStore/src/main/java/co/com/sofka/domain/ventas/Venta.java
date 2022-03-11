package co.com.sofka.domain.ventas;



import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.inventario.value.InventarioID;
import co.com.sofka.domain.inventario.value.ProductoID;
import co.com.sofka.domain.ventas.event.*;
import co.com.sofka.domain.ventas.value.*;

import java.util.Objects;


public class Venta extends AggregateEvent<VentaID> {

    protected Cliente cliente;
    protected Fecha fecha;
    protected Pago pago;
    protected Orden orden;
    protected VendedorID vendedorID;
    protected EnvioID envioID;
    protected Total total;
    protected Factura factura;


    public Venta(VentaID entityId, Cliente cliente, VendedorID vendedorID) {
        super(entityId);
        this.cliente = cliente;
        this.vendedorID = vendedorID;
        appendChange(new VentaCreada(cliente, vendedorID)).apply();
    }

    /*todo crear el evento EnvioCreado
     public Boolean validarEnvio(Boolean hayEnvio){
        if (hayEnvio){
            appendChange(new EnvioCreado()).apply();
        }
        return null;
    }*/

        public void cambiarVendedor(VendedorID vendedorID){
        appendChange(new VendedorCambiado(vendedorID)).apply();
    }

    public void actualizarCliente(ClienteID clienteID, Cliente cliente){
        Objects.requireNonNull(cliente);
        appendChange(new ClienteActualizado(clienteID, cliente)).apply();
    }

    public void agregarProducto(InventarioID inventarioID, Producto producto){
        Objects.requireNonNull(inventarioID);
        Objects.requireNonNull(producto);
        appendChange(new ProductoAgregado(inventarioID, producto)).apply();
    }

    public void eliminarProducto(ProductoID productoID){
        appendChange(new ProductoEliminado(productoID)).apply();
    }

    public void agregarVentaAVendedor(VentaID ventaID, VendedorID vendedorID){
        Objects.requireNonNull(ventaID);
        Objects.requireNonNull(vendedorID);
        appendChange(new VentaAgregadaAVendedor(ventaID, vendedorID)).apply();
    }

    public void generarFactura(Factura factura){
        Objects.requireNonNull(factura);
        appendChange(new FacturaGenerada(factura)).apply();
    }

    public void calcularTotal(Total total){
        Objects.requireNonNull(total);
        appendChange(new TotalCalculado(total)).apply();
    }

    public void pagarVenta(Pago pago){
        Objects.requireNonNull(pago);
        appendChange(new VentaPagada(pago)).apply();
    }

    public Cliente Cliente() {
        return cliente;
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

    public VendedorID VendedorID() {
        return vendedorID;
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
}
