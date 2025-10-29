package diaconat_mulhouse.fr.backend.domain.entities.User;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final long id;
    private final String lastName;
    private final String firstName;
    private final String email;
    private final String password;
    private final List<Establishment> establishments;
    private final LocalDateTime createdAt;


    // * CONSTRUCTOR * //
    public User(long id, String lastName, String firstName, String email, String password, List<Establishment> establishments, LocalDateTime createdAt) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.establishments = establishments;
        this.createdAt = createdAt;
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

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
