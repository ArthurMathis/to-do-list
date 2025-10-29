package diaconat_mulhouse.fr.backend.core.gateways.establishment.get;

import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
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
