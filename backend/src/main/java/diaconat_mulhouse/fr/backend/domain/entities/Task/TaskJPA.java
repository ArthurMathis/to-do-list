package diaconat_mulhouse.fr.backend.domain.entities.Task;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "tasks")
public class TaskJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String titled;
    private boolean checked = false;

    @ManyToOne()
    @JoinColumn(name = "establishment_id")
    private EstablishmentJPA establishment;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTORS * //
    public TaskJPA(long id, String titled, boolean checked, EstablishmentJPA establishment, LocalDateTime createdAt) {
        this.id = id;
        this.titled = titled;
        this.checked = checked;
        this.establishment = establishment;
        this.createdAt = createdAt;
    }

    public TaskJPA() {
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public String getTitled() {
        return titled;
    }

    public boolean isChecked() {
        return checked;
    }

    public EstablishmentJPA getEstablishment() {
        return establishment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
