package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;
import co.com.sofka.domain.ventas.value.VendedorID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vendedor extends Entity<VendedorID> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected VendedorID vendedorID;
    private List<Vendedor> vendedores = new ArrayList();
    private List<Venta> ventasHechas = new ArrayList<>();

    public Vendedor(VendedorID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Vendedor(VendedorID entityId) {
        super(entityId);
    }

    public Vendedor buscarVendedorPorID(VendedorID vendedorID) {
        Vendedor vendedor1 = new Vendedor(vendedorID);
        Vendedor vendedor2 = new Vendedor(vendedorID);
        for (Vendedor vendedor : vendedores) {
            if (vendedor.entityId.equals(vendedorID)) {
                vendedor1.nombre = vendedor.nombre;
                vendedor1.telefono = vendedor.telefono;
                return vendedor1;
            }
        }
        crearVendedor(vendedorID, nombre, telefono);
        for (Vendedor vendedor3 : vendedores) {
            if (vendedor3.entityId.equals(vendedorID)) {
                vendedor2.nombre = vendedor3.nombre;
                vendedor2.telefono = vendedor3.telefono;
            }
        }
        return vendedor2;
    }

    public void crearVendedor(VendedorID vendedorID, Nombre nombre, Telefono telefono) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.entityId.equals(vendedorID)) {
                System.out.println("Cliente ya existe");
            }
            Vendedor vendedorsito = new Vendedor(vendedorID, nombre, telefono);
            vendedores.add(vendedorsito);
        }
    }

    public void eliminarVendedor(VendedorID vendedorID) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.entityId.equals(vendedorID)) {
                vendedores.remove(vendedor);
            } else {
                System.out.println("Cliente no encontrado");
            }
        }
    }

    public void actualizarVendedorExistente(VendedorID entityId, Nombre nombre, Telefono telefono) {
        eliminarVendedor(entityId);
        crearVendedor(entityId, nombre, telefono);
    }

    public void agregarVenta(Venta venta) {
        ventasHechas.add(Objects.requireNonNull(venta));
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public VendedorID vendedorID(){
        return vendedorID;
    }


}
