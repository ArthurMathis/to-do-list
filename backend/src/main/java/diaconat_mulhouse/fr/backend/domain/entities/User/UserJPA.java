package diaconat_mulhouse.fr.backend.domain.entities.User;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class UserJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String lastName;
    private String firstName;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
        name = "work_in",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "establishment_id")
    )
    private List<EstablishmentJPA> establishments = new ArrayList<EstablishmentJPA>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public UserJPA(long id, String lastName, String firstName, String email, String password, List<EstablishmentJPA> establishments, LocalDateTime createdAt) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.establishments = establishments;
        this.createdAt = createdAt;
    }

    public UserJPA() {
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<EstablishmentJPA> getEstablishments() {
        return establishments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
