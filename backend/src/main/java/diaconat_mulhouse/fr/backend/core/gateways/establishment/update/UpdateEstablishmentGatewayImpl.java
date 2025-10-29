package diaconat_mulhouse.fr.backend.core.gateways.establishment.update;

import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;
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
