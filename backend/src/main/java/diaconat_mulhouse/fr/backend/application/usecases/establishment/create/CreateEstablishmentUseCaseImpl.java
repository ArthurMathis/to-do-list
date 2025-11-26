package diaconat_mulhouse.fr.backend.application.usecases.establishment.create;

import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.create.CreateEstablishmentGateway;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;

public class CreateEstablishmentUseCaseImpl implements CreateEstablishmentUseCase {

    private final CreateEstablishmentGateway createEstablishmentGateway;

    public CreateEstablishmentUseCaseImpl(CreateEstablishmentGateway createEstablishmentGateway) {
        this.createEstablishmentGateway = createEstablishmentGateway;
    }

    @Override
    public Long execute(Establishment establishment) {
        return this.createEstablishmentGateway.create(establishment);
    }
}
