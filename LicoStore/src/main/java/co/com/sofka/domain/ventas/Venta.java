package co.com.sofka.domain.ventas;

import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.inventario.value.*;
import co.com.sofka.domain.ventas.event.*;
import co.com.sofka.domain.ventas.value.*;
import co.com.sofka.domain.ventas.value.Telefono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Venta extends AggregateEvent<VentaID> {

    protected List<Vendedor> vendedores = new ArrayList();
    protected Vendedor vendedor;
    protected Telefono telefono;
    protected Nombre nombre;
    protected Cliente cliente;
    protected Fecha fecha;
    protected Pago pago = new Pago(Pago.Fase.NO_PAGADO);
    protected Orden orden;
    protected EnvioID envioID;
    protected Total total;
    protected Factura factura;
    protected List<Cliente> clientes = new ArrayList();


    public Venta(VentaID entityId,
                 Fecha fecha) {
        super(entityId);
        subscribe(new VentaChange(this));
        appendChange(new VentaCreada(fecha)).apply();
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



    public void crearVendedorEvento(VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(vendedorID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new VendedorCreado(vendedorID, nombre, telefono)).apply();
    }

    public void crearClienteEvento(ClienteID clienteID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new ClienteCreado(clienteID, nombre, telefono)).apply();
    }

    public void asignarCliente(ClienteID clienteID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange((new ClienteAsignado(clienteID, nombre, telefono))).apply();
    }

    public void asignarVendedor(VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(vendedorID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new VendedorAsignado(vendedorID, nombre, telefono)).apply();
    }

    public void cambiarVendedorEvento(VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(vendedorID);
        appendChange(new VendedorCambiado(vendedorID, nombre, telefono)).apply();
    }

    public void actualizarClienteEvento(ClienteID clienteID, Nombre nombre, Telefono telefono) {
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
        appendChange(new ProductoAgregado(productoID, nombreProducto, precio, descripcion, cantidad)).apply();
    }

    public void eliminarProducto(ProductoID productoID) {
        appendChange(new ProductoEliminado(productoID)).apply();
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


    public Cliente buscarClientePorID(ClienteID clienteID) {
        Cliente cliente1 = new Cliente(clienteID);
        Cliente cliente2 = new Cliente(clienteID);
        for (Cliente cliente : clientes) {
            if (cliente.identity().equals(clienteID)) {
                cliente1.nombre = cliente.Nombre();
                cliente1.telefono = cliente.Telefono();
                return cliente1;
            }
        }
        crearCliente(clienteID, nombre, telefono);
        for (Cliente cliente3 : clientes) {
            if (cliente3.identity().equals(clienteID)) {
                cliente2.nombre = cliente3.Nombre();
                cliente2.telefono = cliente3.Telefono();
            }
        }

        return cliente2;
    }


    public void crearCliente(ClienteID clienteId, Nombre nombre, Telefono telefono) {
        for (Cliente cliente : clientes) {
            if (cliente.identity().equals(clienteId)) {
                System.out.println("Cliente ya existe");
            } else {
                Cliente clientito = new Cliente(clienteId, nombre, telefono);
                clientes.add(clientito);
            }

        }
    }

    public void eliminarCliente(ClienteID clienteId) {
        for (Cliente cliente : clientes) {
            if (cliente.identity().equals(clienteId)) {
                clientes.remove(cliente);
            } else {
                System.out.println("Cliente no encontrado");
            }
        }
    }

    public void actualizarCliente(ClienteID clienteId, Nombre nombre, Telefono telefono) {
        eliminarCliente(clienteId);
        crearCliente(clienteId, nombre, telefono);
    }


    public Vendedor buscarVendedorPorID(VendedorID vendedorID) {
        Vendedor vendedor1 = new Vendedor(vendedorID);
        Vendedor vendedor2 = new Vendedor(vendedorID);
        for (Vendedor vendedor : vendedores) {
            if (vendedor.identity().equals(vendedorID)) {
                vendedor1.nombre = vendedor.Nombre();
                vendedor1.telefono = vendedor.Telefono();
                return vendedor1;
            }
        }
        crearVendedor(vendedorID, nombre, telefono);
        for (Vendedor vendedor3 : vendedores) {
            if (vendedor3.identity().equals(vendedorID)) {
                vendedor2.nombre = vendedor3.Nombre();
                vendedor2.telefono = vendedor3.Telefono();
            }
        }
        return vendedor2;
    }

    public void crearVendedor(VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.identity().equals(vendedorID)) {
                System.out.println("Vendedor ya existe");
            }
            Vendedor vendedorsito = new Vendedor(vendedorID, nombre, telefono);
            vendedores.add(vendedorsito);
        }
    }

    public void eliminarVendedor(VendedorID vendedorID) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.identity().equals(vendedorID)) {
                vendedores.remove(vendedor);
            } else {
                System.out.println("Vendedor no encontrado");
            }
        }
    }

    public void actualizarVendedorExistente(VendedorID entityId, Nombre nombre, Telefono telefono) {
        eliminarVendedor(entityId);
        crearVendedor(entityId, nombre, telefono);
    }


    public Telefono Telefono() {
        return telefono;
    }

    public Nombre Nombre() {
        return nombre;
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

    public Cliente cliente() {
        return cliente;
    }




}
