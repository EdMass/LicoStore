package co.com.sofka.domain.envio;
import co.com.sofka.domain.envio.value.Telefono;
import co.com.sofka.domain.envio.value.Nombre;
import co.com.sofka.domain.envio.value.Direccion;
import co.com.sofka.domain.ventas.Cliente;
import co.com.sofka.domain.ventas.value.ClienteID;

public class Destinatario extends Cliente {

    protected Direccion direccion;
    protected ClienteID clienteID;
    protected Nombre nombre;
    protected Telefono telefono;

    public Destinatario (ClienteID clienteID,Direccion direccion, Nombre nombre, Telefono telefono) {

        super(clienteID);
        this.clienteID= clienteID;
        this.direccion= direccion;
        this.nombre=nombre;
        this.telefono= telefono;

    }

    public Direccion getDireccion() {
        return direccion;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Direccion direccion() {
        return direccion;
    }
    public void agregarDireccionACliente(ClienteID clienteID, Nombre nombre){

    }

}