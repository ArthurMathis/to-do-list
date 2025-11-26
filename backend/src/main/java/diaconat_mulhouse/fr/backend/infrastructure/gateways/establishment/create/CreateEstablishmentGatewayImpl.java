package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.create;

import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;

public class CreateEstablishmentGatewayImpl implements CreateEstablishmentGateway {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentJPAConverter establishmentJPAConverter;

    public CreateEstablishmentGatewayImpl(EstablishmentRepository establishmentRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentJPAConverter = establishmentJPAConverter;
    }

    @Override
    public long create(Establishment establishment) {
        EstablishmentJPA establishmentJPA = this.establishmentJPAConverter.fromDto(establishment);
        EstablishmentJPA savedEstablishment = this.establishmentRepository.save(establishmentJPA);
        return savedEstablishment.getId();
    }
}
