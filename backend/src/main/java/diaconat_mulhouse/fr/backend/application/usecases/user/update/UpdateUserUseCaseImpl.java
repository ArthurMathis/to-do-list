package diaconat_mulhouse.fr.backend.application.usecases.user.update;

import diaconat_mulhouse.fr.backend.core.gateways.user.update.UpdateUserGateway;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

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
