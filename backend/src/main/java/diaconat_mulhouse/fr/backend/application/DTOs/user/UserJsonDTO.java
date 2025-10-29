package diaconat_mulhouse.fr.backend.application.DTOs.user;

import java.time.LocalDateTime;
import java.util.List;

public class UserJsonDTO {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final List<Long> establishmentsId;
    private final LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public UserJsonDTO(long id, String firstName, String lastName, String email, String password, List<Long> establishmentsId, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.establishmentsId = establishmentsId;
        this.createdAt = createdAt;
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Long> getEstablishmentsId() {
        return establishmentsId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
