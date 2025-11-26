package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.create;

import diaconat_mulhouse.fr.backend.application.converters.user.jpa.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;

public class CreateUserGatewayImpl implements  CreateUserGateway {

    private final UserRepository userRepository;
    private final UserJPAConverter userJPAConverter;

    public CreateUserGatewayImpl(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        this.userRepository = userRepository;
        this.userJPAConverter = userJPAConverter;
    }

    @Override
    public long create(User user) {
        UserJPA createdUser = this.userJPAConverter.fromDto(user);
        return this.userRepository.save(createdUser).getId();
    }
}
