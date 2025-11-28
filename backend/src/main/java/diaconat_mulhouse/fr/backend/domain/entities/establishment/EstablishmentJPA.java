package diaconat_mulhouse.fr.backend.domain.entities.establishment;

import diaconat_mulhouse.fr.backend.domain.entities.project.ProjectJPA;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "establishments")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"users", "projects"})
public class EstablishmentJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String city;
    private String postCode;

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
        name = "work_at",
        joinColumns = @JoinColumn(name = "establishment_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserJPA> users = new ArrayList<>();

    @OneToMany(mappedBy = "establishment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectJPA> projects = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}
