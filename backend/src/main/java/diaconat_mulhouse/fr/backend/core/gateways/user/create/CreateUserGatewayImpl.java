package diaconat_mulhouse.fr.backend.core.gateways.user.create;

import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;
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
        UserJPA savedUser = this.userRepository.save(createdUser);
        return savedUser.getId();
    }
}
