package diaconat_mulhouse.fr.backend.core.security.Jwt.exceptions;

public class InvalidJwtException extends Exception {

    public InvalidJwtException(String errorMessage) {
        super(errorMessage);
    }
}
