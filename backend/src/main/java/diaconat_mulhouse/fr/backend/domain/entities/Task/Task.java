package diaconat_mulhouse.fr.backend.domain.entities.Task;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

import java.time.LocalDateTime;

/**
 * Class that represents a Task in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class Task {

    private final long id;
    private final String titled;
    private final Establishment establishment;
    private final boolean checked;
    private final LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public Task(long id, String titled, boolean checked, Establishment establishment, LocalDateTime createdAt) {
        this.id = id;
        this.titled = titled;
        this.establishment = establishment;
        this.checked = checked;
        this.createdAt = createdAt;
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public String getTitled() {
        return titled;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public boolean isChecked() {
        return checked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
