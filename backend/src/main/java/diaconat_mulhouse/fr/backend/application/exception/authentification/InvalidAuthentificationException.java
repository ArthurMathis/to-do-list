package diaconat_mulhouse.fr.backend.application.exception.authentification;

public class InvalidAuthentificationException extends RuntimeException {
    public InvalidAuthentificationException(String errorMessage) {
        super(errorMessage);
    }
}
