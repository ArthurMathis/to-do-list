package diaconat_mulhouse.fr.backend.application.usecases.establishment.get;

import diaconat_mulhouse.fr.backend.core.gateways.establishment.get.GetEstablishmentGateway;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

public class GetEstablishmentUseCaseImpl implements  GetEstablishmentUseCase {

    private final GetEstablishmentGateway getEstablishmentGateway;

    public GetEstablishmentUseCaseImpl(GetEstablishmentGateway getEstablishmentGateway) {
        this.getEstablishmentGateway = getEstablishmentGateway;
    }

    @Override
    public Establishment execute(Long id) {
        return this.getEstablishmentGateway.get(id);
    }
}
