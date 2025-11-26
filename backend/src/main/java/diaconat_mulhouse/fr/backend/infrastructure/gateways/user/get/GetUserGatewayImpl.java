package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.get;

import diaconat_mulhouse.fr.backend.application.converters.user.jpa.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
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
