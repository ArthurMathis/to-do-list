package diaconat_mulhouse.fr.backend.application.DTOs.user;

public class LoginUserDTO {

    private final String email;
    private final String password;

    // * CONSTRUCTOR * //
    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // * GETTERS * //
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
