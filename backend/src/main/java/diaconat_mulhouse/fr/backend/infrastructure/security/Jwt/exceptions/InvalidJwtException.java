package diaconat_mulhouse.fr.backend.infrastructure.security.Jwt.exceptions;

public class InvalidJwtException extends Exception {

    public InvalidJwtException(String errorMessage) {
        super(errorMessage);
    }
}
