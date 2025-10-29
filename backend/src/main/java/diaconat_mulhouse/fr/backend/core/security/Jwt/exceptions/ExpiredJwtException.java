package diaconat_mulhouse.fr.backend.core.security.Jwt.exceptions;

public class ExpiredJwtException extends Exception {

    public ExpiredJwtException(String errorMessage) {
        super(errorMessage);
    }
}
