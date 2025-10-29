package diaconat_mulhouse.fr.backend.domain.entities.Establishment;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class Establishment {

    private final long id;
    private final String name;
    private final String address;
    private final LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public Establishment(long id, String name, String address, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createdAt = createdAt;
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
