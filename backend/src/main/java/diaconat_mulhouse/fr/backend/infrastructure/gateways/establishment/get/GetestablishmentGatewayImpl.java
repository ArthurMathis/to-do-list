package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get;

import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import jakarta.persistence.EntityNotFoundException;

public class GetestablishmentGatewayImpl implements GetEstablishmentGateway{

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentJPAConverter establishmentJPAConverter;

    public GetestablishmentGatewayImpl(EstablishmentRepository establishmentRepository,EstablishmentJPAConverter establishmentJPAConverter) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentJPAConverter = establishmentJPAConverter;
    }

    public Establishment get(long id) {
        EstablishmentJPA fetchedEstablishment = this.establishmentRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Establishment with id: " + id + " not found");
        });
        return this.establishmentJPAConverter.toDto(fetchedEstablishment);
    }
}
