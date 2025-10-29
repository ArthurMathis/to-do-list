package diaconat_mulhouse.fr.backend.domain.entities.Establishment;

import diaconat_mulhouse.fr.backend.domain.entities.LogableEntity;

import java.time.LocalDateTime;

public class Establishment extends LogableEntity {

    private final String name;
    private final String address;

    // * CONSTRUCTOR * //
    public Establishment(long id, String name, String address, LocalDateTime createdAt) {
        super(id, createdAt);
        this.name = name;
        this.address = address;
    }

    // * GETTERS * //
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
