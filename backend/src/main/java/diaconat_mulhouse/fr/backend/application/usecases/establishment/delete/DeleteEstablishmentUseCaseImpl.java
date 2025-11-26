package diaconat_mulhouse.fr.backend.application.usecases.establishment.delete;

import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.delete.DeleteEstablishmentGateway;

public class DeleteEstablishmentUseCaseImpl implements DeleteEstablishmentUseCase {

    private final DeleteEstablishmentGateway deleteEstablishmentGateway;

    public DeleteEstablishmentUseCaseImpl(DeleteEstablishmentGateway deleteEstablishmentGateway) {
        this.deleteEstablishmentGateway = deleteEstablishmentGateway;
    }

    @Override
    public Void execute(Long id) {
        this.deleteEstablishmentGateway.delete(id);
        return null;
    }
}
