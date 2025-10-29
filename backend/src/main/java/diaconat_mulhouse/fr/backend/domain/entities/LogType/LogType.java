package diaconat_mulhouse.fr.backend.domain.entities.LogType;

import java.time.LocalDateTime;

public class LogType {

    private long id;
    private String title;
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public LogType(long id, String title, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
