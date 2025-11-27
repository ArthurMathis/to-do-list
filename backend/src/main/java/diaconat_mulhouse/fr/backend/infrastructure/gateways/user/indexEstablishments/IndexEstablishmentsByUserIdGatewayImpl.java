package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.indexEstablishments;

import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class IndexEstablishmentsByUserIdGatewayImpl implements IndexEstablishmentsByUserIdGateway {

    private final UserRepository userRepository;
    private final EstablishmentJPAConverter establishmentJPAConverter;

    @Override
    public List<Establishment> indexEstablishment(long userId) {
        UserJPA fetchedUser = this.userRepository.findById(userId).orElseThrow(() -> {
            return new EntityNotFoundException("User not found with id: " + userId);
        });
        return fetchedUser.getEstablishments().stream().map(this.establishmentJPAConverter::toDto).toList();
    }
}
