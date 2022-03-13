package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.Telefono;
import co.com.sofka.domain.ventas.value.VentaID;

public class ActualizarCliente extends Command {

    private final VentaID ventaID;
    private final ClienteID clienteID;
    private final Nombre nombre;
    private final Telefono telefono;

    public ActualizarCliente(VentaID ventaID, ClienteID clienteID, Nombre nombre, Telefono telefono) {
        this.ventaID = ventaID;
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
