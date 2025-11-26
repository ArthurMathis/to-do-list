package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.index;

import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;

import java.util.List;

public class IndexEstablishmentGatewayImpl implements IndexEstablishmentGateway {

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentJPAConverter  establishmentJPAConverter;

    public IndexEstablishmentGatewayImpl(EstablishmentRepository establishmentRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentJPAConverter = establishmentJPAConverter;
    }

    @Override
    public List<Establishment> index() {
        return this.establishmentRepository.findAll().stream().map(this.establishmentJPAConverter::toDto).toList();
    }
}
