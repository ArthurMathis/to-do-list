package diaconat_mulhouse.fr.backend.domain.entities.Task;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.LogableEntity;

import java.time.LocalDateTime;

/**
 * Class that represents a Task in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class Task extends LogableEntity {

    private final String titled;
    private final Establishment establishment;
    private final boolean checked;

    // * CONSTRUCTOR * //
    public Task(long id, String titled, boolean checked, Establishment establishment, LocalDateTime createdAt) {
        super(id, createdAt);
        this.titled = titled;
        this.establishment = establishment;
        this.checked = checked;
    }

    // * GETTERS * //
    public String getTitled() {
        return titled;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public boolean isChecked() {
        return checked;
    }
}
