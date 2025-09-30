package diaconat_mulhouse.fr.backend.domain.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "tasks")
public class TaskJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String titled;
    private boolean checked = false;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // * CONSTRUCTORS * //
    public TaskJPA(long id, String titled, boolean checked, LocalDateTime createdAt) {
        this.id = id;
        this.titled = titled;
        this.checked = checked;
        this.createdAt = createdAt;
    }

    public TaskJPA(long id, String titled, boolean checked) {
        this.id = id;
        this.titled = titled;
        this.checked = checked;
    }

    public TaskJPA(String titled, boolean checked) {
        this.titled = titled;
        this.checked = checked;
    }

    public TaskJPA(String titled) {
        this.titled = titled;
    }

    public TaskJPA() {
    }

    // * GETTERS & SETTERS * //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitled() {
        return titled;
    }

    public void setTitled(String titled) {
        this.titled = titled;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
