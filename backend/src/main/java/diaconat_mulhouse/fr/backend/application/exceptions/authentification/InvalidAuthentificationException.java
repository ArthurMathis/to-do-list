package diaconat_mulhouse.fr.backend.application.exceptions.authentification;

public class InvalidAuthentificationException extends RuntimeException {
    public InvalidAuthentificationException(String errorMessage) {
        super(errorMessage);
    }
}
