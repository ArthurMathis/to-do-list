package diaconat_mulhouse.fr.backend.domain.entities.Task;

import diaconat_mulhouse.fr.backend.domain.entities.Project.ProjectJPA;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tasks")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class TaskJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String titled;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean checked = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectJPA project;

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        }
    )
    @JoinTable(
        name = "work_to",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserJPA> users = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTORS * //
    public TaskJPA(Long id, String titled, String description, boolean checked, ProjectJPA project, List<UserJPA> users, LocalDateTime createdAt) {
        this.id = id;
        this.titled = titled;
        this.description = description;
        this.checked = checked;
        this.project = project;
        this.users = users;
        this.createdAt = createdAt;
    }

}
