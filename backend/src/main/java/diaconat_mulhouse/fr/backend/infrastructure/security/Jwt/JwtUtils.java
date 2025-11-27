package diaconat_mulhouse.fr.backend.infrastructure.security.Jwt;

import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.TokenUserData;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    public static TokenUserData getCurrentToken() throws BadCredentialsException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof TokenUserData tokenUser) {
            return tokenUser;
        }

        throw new BadCredentialsException("Unauthorised access.");
    }
}
