package co.com.sofka.domain.ventas;



import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.inventario.value.InventarioID;
import co.com.sofka.domain.inventario.value.ProductoID;
import co.com.sofka.domain.ventas.event.*;
import co.com.sofka.domain.ventas.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Venta extends AggregateEvent<VentaID> {

    protected Set<Cliente> clientes;
    protected Fecha fecha;
    protected Pago pago;
    protected Orden orden;
    protected Set<Vendedor> vendedores;
    protected EnvioID envioID;
    protected Total total;
    protected Factura factura;


    public Venta(VentaID entityId,
                 Nombre nombreCliente,
                 Telefono telefonoCliente,
                 VendedorID vendedorID) {
        super(entityId);
        subscribe(new VentaChange(this));
        appendChange(new VentaCreada(nombreCliente,telefonoCliente, vendedorID)).apply();
    }

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


    public void cambiarVendedor(VendedorID vendedorID){
        appendChange(new VendedorCambiado(vendedorID)).apply();
    }

    public void actualizarCliente(Cliente cliente){
        Objects.requireNonNull(cliente);

        appendChange(new ClienteActualizado(cliente)).apply();
    }

    public void crearProducto(){

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

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public Set<Vendedor> getVendedores() {
        return vendedores;
    }
}
