package co.com.sofka.domain.envio;

import co.com.sofka.domain.envio.event.*;
import co.com.sofka.domain.envio.value.EnvioID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.envio.value.*;
import co.com.sofka.domain.ventas.value.ClienteID;
import co.com.sofka.domain.ventas.value.Nombre;
import co.com.sofka.domain.ventas.value.VentaID;
import co.com.sofka.domain.ventas.value.Fecha;

import java.util.Objects;


public class Envio extends AggregateEvent<EnvioID> {

    protected DestinatarioID destinatarioID;
    protected Fecha fecha;
    protected Descripcion descripcion;
    protected VentaID ventaID;

    public Envio(EnvioID entityId,
                 Direccion direccion, Descripcion descripcion,
                 DomiciliarioID domiciliarioID, VentaID ventaID
            , DestinatarioID destinatarioID
    ) {
        super(entityId);
        subscribe(new EnvioChange(this));
        appendChange(new EnvioCreado(domiciliarioID, destinatarioID,
                direccion, descripcion, ventaID, fecha));

    }

    private Envio(EnvioID entityId) {
        super(entityId);
        subscribe(new EnvioChange(this));
    }

    public void asignarDescripcion(EnvioID envioID, Descripcion descripcion) {
        Objects.requireNonNull(envioID);
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionAsignada(envioID, descripcion)).apply();

    }

    public void actualizarDireccion(Direccion direccion, DestinatarioID destinatarioID) {
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(destinatarioID);
        appendChange(new DireccionActualizada(direccion, destinatarioID)).apply();
    }

    public void asignarDireccionDestinatario(ClienteID clienteID, Direccion direccion) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(direccion);
        appendChange(new DireccionDestinatarioAsignada(clienteID, direccion)).apply();
    }

    public void asignarDomiciliario(EnvioID envioID, DomiciliarioID domiciliarioID) {
        Objects.requireNonNull(envioID);
        Objects.requireNonNull(domiciliarioID);
        appendChange(new DomiciliarioAsignado(envioID, domiciliarioID)).apply();
    }

    public void crearEnvio(DomiciliarioID domiciliarioID, DestinatarioID destinatarioID,
                           Direccion direccion, Descripcion descripcion,
                           VentaID ventaID, Fecha fecha) {
        Objects.requireNonNull(domiciliarioID);
        Objects.requireNonNull(destinatarioID);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(ventaID);
        Objects.requireNonNull(fecha);
        appendChange(new EnvioCreado(domiciliarioID, destinatarioID, direccion, descripcion, ventaID, fecha)).apply();
    }

    public void asignarNombreDestinatario(ClienteID clienteID, Nombre nombre) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(nombre);
        appendChange(new NombreDestinatarioAsignado(clienteID, nombre)).apply();
    }

    public void asignarDestinatarioTelefono(ClienteID clienteID, Telefono telefono) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoDestinatarioAsignado(clienteID, telefono)).apply();
    }

    public DestinatarioID destinatarioID() {
        return destinatarioID;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public VentaID ventaID() {
        return ventaID;
    }
}
