package diaconat_mulhouse.fr.backend.core.gateways.user.update;

import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;

public class UpdateUserGatewayImpl implements UpdateUserGateway {

    private final UserRepository userRepository;
    private final UserJPAConverter userJPAConverter;

    public UpdateUserGatewayImpl(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        this.userRepository = userRepository;
        this.userJPAConverter = userJPAConverter;
    }

    @Override
    public void udapte(User user) {
        UserJPA updatedUser = this.userJPAConverter.fromDto(user);
        this.userRepository.save(updatedUser);
    }
}
