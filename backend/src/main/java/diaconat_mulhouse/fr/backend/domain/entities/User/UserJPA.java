package diaconat_mulhouse.fr.backend.domain.entities.User;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.LogableJpaEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class UserJPA extends LogableJpaEntity {

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

    // * CONSTRUCTOR * //
    public UserJPA(Long id, String lastName, String firstName, String email, String password, List<EstablishmentJPA> establishments, LocalDateTime createdAt) {
        super(id, createdAt);
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.establishments = establishments;
    }

    public UserJPA() {
    }

    // * GETTERS * //
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
}
