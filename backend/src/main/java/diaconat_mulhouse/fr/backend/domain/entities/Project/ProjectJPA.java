package diaconat_mulhouse.fr.backend.domain.entities.Project;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.Task.TaskJPA;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "projects")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ProjectJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "establishment_id")
    private EstablishmentJPA establishment;

    @OneToMany(mappedBy = "tasks", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TaskJPA> tasks = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public ProjectJPA(Long id, String title, String description, EstablishmentJPA establishment, List<TaskJPA> tasks, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.establishment = establishment;
        this.tasks = tasks;
        this.createdAt = createdAt;
    }

}
