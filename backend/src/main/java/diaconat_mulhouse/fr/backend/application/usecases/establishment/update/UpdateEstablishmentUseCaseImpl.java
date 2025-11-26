package diaconat_mulhouse.fr.backend.application.usecases.establishment.update;

import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.update.UpdateEstablishmentGateway;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;

public class UpdateEstablishmentUseCaseImpl implements UpdateEstablishmentUseCase {

    private final UpdateEstablishmentGateway updateEstablishmentGateway;

    public UpdateEstablishmentUseCaseImpl(UpdateEstablishmentGateway updateEstablishmentGateway) {
        this.updateEstablishmentGateway = updateEstablishmentGateway;
    }

    @Override
    public Void execute(Establishment establishment) {
        this.updateEstablishmentGateway.udapte(establishment);
        return null;
    }
}
