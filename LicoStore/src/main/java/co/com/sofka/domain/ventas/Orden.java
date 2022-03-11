package co.com.sofka.domain.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.inventario.Producto;
import co.com.sofka.domain.ventas.value.OrdenID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Orden extends Entity<OrdenID> {

    private List<Producto> productosOrden= new ArrayList<>();

    public Orden(OrdenID entityId) {

        super(entityId);
    }
    public void agregarProducto(Producto producto){
        productosOrden.add(Objects.requireNonNull(producto));
    }

    public void eliminarProducto(OrdenID productoID){
        for (Producto producto:productosOrden) {
            if(producto.identity().equals(productoID)){
                productosOrden.remove(producto);
            }
            else{
                System.out.println("Producto no encontrado");
            }
        }
    }

    public List<Producto> listarProductos(){
        return productosOrden;
    }

}

