package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;
import co.com.sofka.domain.ventas.value.VendedorID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vendedor extends Entity<VendedorID> {

    protected Nombre nombre;
    protected Telefono telefono;
    private List<Vendedor> vendedores = new ArrayList();
    private List<Venta> ventasHechas = new ArrayList<>();

    public Vendedor(VendedorID entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void crearVendedor(VendedorID vendedorID, Nombre nombre, Telefono telefono){
        for (Vendedor vendedor: vendedores) {
            if(vendedor.entityId.equals(vendedorID)){
                System.out.println("Cliente ya existe");
            }
            Vendedor vendedorsito = new Vendedor(vendedorID, nombre, telefono);
            vendedores.add(vendedorsito);
        }
    }

    public void eliminarVendedor(VendedorID vendedorID){
        for (Vendedor vendedor: vendedores) {
            if(vendedor.entityId.equals(vendedorID)){
                vendedores.remove(vendedor);
            }
            else{
                System.out.println("Cliente no encontrado");
            }
        }
    }

    public void actualizarVendedor(VendedorID entityId,Nombre nombre, Telefono telefono){
        eliminarVendedor(entityId);
        crearVendedor(entityId, nombre, telefono);
    }

    public void agregarVenta (Venta venta){
        ventasHechas.add(Objects.requireNonNull(venta));
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }
}
