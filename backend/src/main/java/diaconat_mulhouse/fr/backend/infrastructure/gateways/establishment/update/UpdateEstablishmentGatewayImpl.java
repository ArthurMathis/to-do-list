package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.update;

import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;

public class UpdateEstablishmentGatewayImpl implements UpdateEstablishmentGateway {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentJPAConverter establishmentJPAConverter;

    public UpdateEstablishmentGatewayImpl(EstablishmentRepository establishmentRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentJPAConverter = establishmentJPAConverter;
    }

    @Override
    public void udapte(Establishment establishment) {
        EstablishmentJPA establishmentJPA = this.establishmentJPAConverter.fromDto(establishment);
        this.establishmentRepository.save(establishmentJPA);
    }
}
