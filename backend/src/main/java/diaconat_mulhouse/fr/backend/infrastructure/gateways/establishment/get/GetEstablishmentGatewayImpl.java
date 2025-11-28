package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get;

import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetEstablishmentGatewayImpl implements GetEstablishmentGateway {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentJPAConverter establishmentJPAConverter;

    @Override
    public Establishment get(long id) {
        return this.establishmentJPAConverter.toDto(this.establishmentRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Establishment with id: " + id + " not found");
        }));
    }
}
