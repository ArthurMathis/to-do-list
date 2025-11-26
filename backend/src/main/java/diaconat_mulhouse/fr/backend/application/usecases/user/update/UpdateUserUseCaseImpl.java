package diaconat_mulhouse.fr.backend.application.usecases.user.update;

import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.update.UpdateUserGateway;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UpdateUserGateway updateUserGateway;

    public UpdateUserUseCaseImpl(UpdateUserGateway updateUserGateway) {
        this.updateUserGateway = updateUserGateway;
    }

    @Override
    public Void execute(User user) {
        this.updateUserGateway.udapte(user);
        return null;
    }
}
