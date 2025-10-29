package diaconat_mulhouse.fr.backend.application.usecases.user.authenticate;

import diaconat_mulhouse.fr.backend.application.DTOs.user.AuthToken;
import diaconat_mulhouse.fr.backend.application.DTOs.user.LoginUserDTO;
import diaconat_mulhouse.fr.backend.application.exception.authentification.InvalidAuthentificationException;
import diaconat_mulhouse.fr.backend.core.gateways.user.authenticate.AuthenticateUserGateway;
import diaconat_mulhouse.fr.backend.core.security.Jwt.JwtProvider;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthenticateUserUseCaseImpl implements AuthenticateUserUseCase {

    private static final String errorMessage = "Authentication failed. Please check your login credentials. ";

    private final AuthenticateUserGateway authenticateUserGateway;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthenticateUserUseCaseImpl(
            AuthenticateUserGateway authenticateUserGateway,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider
    ) {
        this.authenticateUserGateway = authenticateUserGateway;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthToken execute(LoginUserDTO loginUserDTO) {
        User user = Optional.ofNullable(
            this.authenticateUserGateway.getByEmail(loginUserDTO.getEmail())
        ).orElseThrow(() -> new InvalidAuthentificationException(errorMessage));

        if(!this.passwordEncoder.matches(loginUserDTO.getPassword(), user.getPassword())) {
            throw new InvalidAuthentificationException(errorMessage);
        }
        return this.jwtProvider.generateToken(loginUserDTO.getEmail());
    }
}
