package diaconat_mulhouse.fr.backend.domain.entities.User;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.Log.LogJPA;
import diaconat_mulhouse.fr.backend.domain.entities.Role.RoleJPA;
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

@Entity(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleJPA role;

    @ManyToMany(mappedBy = "establishments", fetch = FetchType.LAZY)
    private List<EstablishmentJPA> establishments = new ArrayList<>();

    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    private List<TaskJPA> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "logs", fetch = FetchType.LAZY)
    private List<LogJPA> logs = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public UserJPA(Long id, String lastName, String firstName, String email, String password, RoleJPA role,
                   List<EstablishmentJPA> establishments, List<TaskJPA> tasks, List<LogJPA> logs, LocalDateTime createdAt) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.establishments = establishments;
        this.tasks = tasks;
        this.logs = logs;
        this.createdAt = createdAt;
    }

}
