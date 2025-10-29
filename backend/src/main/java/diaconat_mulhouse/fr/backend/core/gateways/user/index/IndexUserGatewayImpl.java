package diaconat_mulhouse.fr.backend.core.gateways.user.index;

import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;

import java.util.List;

public class IndexUserGatewayImpl implements IndexUserGateway {

    private final UserRepository userRepository;
    private final UserJPAConverter userJPAConverter;

    public IndexUserGatewayImpl(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        this.userRepository = userRepository;
        this.userJPAConverter = userJPAConverter;
    }

    @Override
    public List<User> index() {
        return this.userRepository.findAll().stream().map(this.userJPAConverter::toDto).toList();
    }
}
