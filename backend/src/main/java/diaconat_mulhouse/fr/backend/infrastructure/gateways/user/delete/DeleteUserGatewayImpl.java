package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.delete;

import diaconat_mulhouse.fr.backend.application.converters.user.jpa.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;

public class DeleteUserGatewayImpl implements DeleteUserGateway {

    private final UserRepository userRepository;
    private final UserJPAConverter userJPAConverter;

    public DeleteUserGatewayImpl(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        this.userRepository = userRepository;
        this.userJPAConverter = userJPAConverter;
    }

    @Override
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }

}
