package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class telefonoDestinatarioAsignado extends DomainEvent {
    public telefonoDestinatarioAsignado(String type, String aggregateRootId, String aggregateParentId, UUID uuid) {
        super(type, aggregateRootId, aggregateParentId, uuid);
    }

    public telefonoDestinatarioAsignado(String type, String aggregateRootId, UUID uuid) {
        super(type, aggregateRootId, uuid);
    }

    public telefonoDestinatarioAsignado(String type, UUID uuid) {
        super(type, uuid);
    }

    public telefonoDestinatarioAsignado(String type) {
        super(type);
    }
}
