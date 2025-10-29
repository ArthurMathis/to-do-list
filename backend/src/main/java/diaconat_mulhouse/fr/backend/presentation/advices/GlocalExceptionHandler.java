package diaconat_mulhouse.fr.backend.presentation.advices;

import diaconat_mulhouse.fr.backend.application.exception.authentification.InvalidAuthentificationException;
import diaconat_mulhouse.fr.backend.presentation.advices.apiResponse.ApiError;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class that handles the API Exception and set their HttpStatus
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@RestControllerAdvice
public class GlocalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        HttpStatus httpResponse = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError(httpResponse, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpResponse).body(apiError);
    }

    @ExceptionHandler(InvalidAuthentificationException.class)
    public ResponseEntity<ApiError> handleInvalidAuthentification(InvalidAuthentificationException ex, HttpServletRequest request) {
        HttpStatus httpResponse = HttpStatus.UNAUTHORIZED;
        ApiError apiError = new ApiError(httpResponse, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpResponse).body(apiError);
    }
}
