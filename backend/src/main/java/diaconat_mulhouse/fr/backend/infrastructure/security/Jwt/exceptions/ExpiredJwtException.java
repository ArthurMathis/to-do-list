package diaconat_mulhouse.fr.backend.infrastructure.security.Jwt.exceptions;

public class ExpiredJwtException extends Exception {

    public ExpiredJwtException(String errorMessage) {
        super(errorMessage);
    }
}
