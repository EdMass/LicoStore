package co.com.sofka.domain.ventas.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.VentaID;

public class AsignarCliente extends Command {

    private final VentaID ventaID;
    private final ClienteID clienteID;

    public AsignarCliente(VentaID ventaID, ClienteID clienteID) {
        this.ventaID = ventaID;
        this.clienteID = clienteID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }
}
