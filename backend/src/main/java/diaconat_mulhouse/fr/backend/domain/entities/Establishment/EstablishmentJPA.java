package diaconat_mulhouse.fr.backend.domain.entities.Establishment;

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

@Entity(name = "establishments")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class EstablishmentJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "projects", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectJPA> projects = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public EstablishmentJPA(Long id, String name, String city, String postCode, List<UserJPA> users, List<ProjectJPA> projects, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.postCode = postCode;
        this.users = users;
        this.projects = projects;
        this.createdAt = createdAt;
    }

}
