package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.authenticate;

import diaconat_mulhouse.fr.backend.application.converters.user.jpa.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;

import java.util.Optional;

public class AuthenticateUserGatewayImpl implements AuthenticateUserGateway {

    private final UserRepository userRepository;
    private final UserJPAConverter userJPAConverter;

    public AuthenticateUserGatewayImpl(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        this.userRepository = userRepository;
        this.userJPAConverter = userJPAConverter;
    }

    @Override
    public User getByEmail(String email) {
        Optional<UserJPA> searchedUser = this.userRepository.findByEmail(email);
        return searchedUser.map(this.userJPAConverter::toDto).orElse(null);
    }
}
