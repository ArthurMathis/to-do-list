package diaconat_mulhouse.fr.backend.domain.entities.user;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.log.LogJPA;
import diaconat_mulhouse.fr.backend.domain.entities.role.RoleJPA;
import diaconat_mulhouse.fr.backend.domain.entities.task.TaskJPA;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"role", "establishments", "tasks", "logs"})
public class UserJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<EstablishmentJPA> establishments = new ArrayList<>();

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<TaskJPA> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<LogJPA> logs = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}
