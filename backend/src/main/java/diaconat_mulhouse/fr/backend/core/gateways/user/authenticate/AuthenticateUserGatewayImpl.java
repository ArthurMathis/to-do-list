package diaconat_mulhouse.fr.backend.core.gateways.user.authenticate;

import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;
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
