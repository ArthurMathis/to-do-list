package diaconat_mulhouse.fr.backend.domain.entities.Establishment;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "establishments")
public class EstablishmentJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;
    private String address;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public EstablishmentJPA(long id, String name, String address, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createdAt = createdAt;
    }

    public EstablishmentJPA() {
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
