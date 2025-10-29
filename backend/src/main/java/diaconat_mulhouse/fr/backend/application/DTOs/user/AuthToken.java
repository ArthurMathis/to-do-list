package diaconat_mulhouse.fr.backend.application.DTOs.user;

public class AuthToken {

    private final String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
