package diaconat_mulhouse.fr.backend.core.gateways.establishment.index;

import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.index.IndexEstablishmentGateway;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
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
