package diaconat_mulhouse.fr.backend.application.DTOs.user;

import java.util.List;

public class CreateUserDTO {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final List<Long> establishmentsId;

    // * CONSTRUCTOR * //
    public CreateUserDTO(String firstName, String lastName, String email, String password, List<Long> establishmentsId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.establishmentsId = establishmentsId;
    }

    // * GETTERS * //
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
}
