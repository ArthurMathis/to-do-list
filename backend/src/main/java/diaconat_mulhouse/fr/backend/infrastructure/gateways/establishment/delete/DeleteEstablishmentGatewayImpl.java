package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.delete;

import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;

public class DeleteEstablishmentGatewayImpl implements DeleteEstablishmentGateway {

    private final EstablishmentRepository establishmentRepository;

    public DeleteEstablishmentGatewayImpl(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public void delete(long id) {
        this.establishmentRepository.deleteById(id);
    }
}
