package diaconat_mulhouse.fr.backend.domain.entities.Establishment;

import diaconat_mulhouse.fr.backend.domain.entities.LogableJpaEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "establishments")
public class EstablishmentJPA extends LogableJpaEntity {

    @Column(unique = true)
    private String name;
    private String address;

    // * CONSTRUCTOR * //
    public EstablishmentJPA(Long id, String name, String address, LocalDateTime createdAt) {
        super(id, createdAt);
        this.name = name;
        this.address = address;
    }

    public EstablishmentJPA() {
    }

    // * GETTERS * //
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
