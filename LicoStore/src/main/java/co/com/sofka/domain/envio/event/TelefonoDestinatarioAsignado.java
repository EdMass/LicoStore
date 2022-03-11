package co.com.sofka.domain.envio.event;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class TelefonoDestinatarioAsignado extends DomainEvent {
    public TelefonoDestinatarioAsignado(String type, String aggregateRootId, String aggregateParentId, UUID uuid) {
        super(type, aggregateRootId, aggregateParentId, uuid);
    }

    public TelefonoDestinatarioAsignado(String type, String aggregateRootId, UUID uuid) {
        super(type, aggregateRootId, uuid);
    }

    public TelefonoDestinatarioAsignado(String type, UUID uuid) {
        super(type, uuid);
    }

    public TelefonoDestinatarioAsignado(String type) {
        super(type);
    }
}
