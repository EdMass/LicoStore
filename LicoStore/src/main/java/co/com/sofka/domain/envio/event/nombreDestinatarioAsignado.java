package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class nombreDestinatarioAsignado extends DomainEvent {
    public nombreDestinatarioAsignado(String type, String aggregateRootId, String aggregateParentId, UUID uuid) {
        super(type, aggregateRootId, aggregateParentId, uuid);
    }

    public nombreDestinatarioAsignado(String type, String aggregateRootId, UUID uuid) {
        super(type, aggregateRootId, uuid);
    }

    public nombreDestinatarioAsignado(String type, UUID uuid) {
        super(type, uuid);
    }

    public nombreDestinatarioAsignado(String type) {
        super(type);
    }
}
