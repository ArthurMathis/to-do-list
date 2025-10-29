package diaconat_mulhouse.fr.backend.domain.entities;

import java.time.LocalDateTime;

/**
 * Abstract class that represents a LogableJpaEntity in a classic Entity
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public abstract class LogableEntity {

    private final long id;
    private final LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public LogableEntity(long id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
