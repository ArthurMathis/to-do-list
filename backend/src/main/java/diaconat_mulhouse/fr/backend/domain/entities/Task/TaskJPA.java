package diaconat_mulhouse.fr.backend.domain.entities.Task;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.LogableJpaEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "tasks")
public class TaskJPA extends LogableJpaEntity {

    private String titled;
    private boolean checked = false;

    @ManyToOne()
    @JoinColumn(name = "establishment_id")
    private EstablishmentJPA establishment;

    // * CONSTRUCTORS * //
    public TaskJPA(Long id, String titled, boolean checked, EstablishmentJPA establishment, LocalDateTime createdAt) {
        super(id, createdAt);
        this.titled = titled;
        this.checked = checked;
        this.establishment = establishment;
    }

    public TaskJPA() {
    }

    // * GETTERS * //
    public String getTitled() {
        return titled;
    }

    public boolean isChecked() {
        return checked;
    }

    public EstablishmentJPA getEstablishment() {
        return establishment;
    }
}
