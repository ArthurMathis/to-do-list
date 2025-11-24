package diaconat_mulhouse.fr.backend.domain.entities.Role;

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

@Entity(name = "roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class RoleJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserJPA> users = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public RoleJPA(long id, String title, List<UserJPA> users, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.users = users;
        this.createdAt = created;
    }

}
