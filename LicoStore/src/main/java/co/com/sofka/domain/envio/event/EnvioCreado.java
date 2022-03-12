package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.envio.value.Descripcion;
import co.com.sofka.domain.envio.value.DestinatarioID;
import co.com.sofka.domain.envio.value.Direccion;
import co.com.sofka.domain.envio.value.DomiciliarioID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.ventas.value.Fecha;
import co.com.sofka.domain.ventas.value.VentaID;

public class EnvioCreado extends DomainEvent {
    private final DomiciliarioID domiciliarioID;
    private final DestinatarioID destinatarioID;
    private final Direccion direccion;
    private final Descripcion descripcion;
    private final VentaID ventaID;
    private final Fecha fecha;

    public EnvioCreado(DomiciliarioID domiciliarioID,
                       DestinatarioID destinatarioID,
                       Direccion direccion, Descripcion descripcion,
                       VentaID ventaID, Fecha fecha){
        super("sofka.envio.enviocreado");
        this.destinatarioID=destinatarioID;
        this.domiciliarioID= domiciliarioID;
        this.direccion= direccion;
        this.descripcion=descripcion;
        this.ventaID= ventaID;
        this.fecha= fecha;
    }

    public DomiciliarioID getDomiciliarioID() {
        return domiciliarioID;
    }

    public DestinatarioID getDestinatarioID() {
        return destinatarioID;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
