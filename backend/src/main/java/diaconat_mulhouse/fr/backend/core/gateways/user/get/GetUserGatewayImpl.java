package diaconat_mulhouse.fr.backend.core.gateways.user.get;

import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

public class GetUserGatewayImpl implements GetUserGateway {

    private final UserRepository userRepository;
    private final UserJPAConverter userJPAConverter;

    public GetUserGatewayImpl(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        this.userRepository = userRepository;
        this.userJPAConverter = userJPAConverter;
    }

    @Override
    public User get(long id) {
        UserJPA fetchedUser =  this.userRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("User not found with id: " + id);
        });
        return this.userJPAConverter.toDto(fetchedUser);
    }
}
