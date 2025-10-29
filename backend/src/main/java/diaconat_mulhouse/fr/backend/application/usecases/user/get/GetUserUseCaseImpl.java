package diaconat_mulhouse.fr.backend.application.usecases.user.get;

import diaconat_mulhouse.fr.backend.core.gateways.user.get.GetUserGateway;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

public class GetUserUseCaseImpl implements GetUserUseCase {

    private final GetUserGateway getUserGateway;

    public GetUserUseCaseImpl(GetUserGateway getUserGateway) {
        this.getUserGateway = getUserGateway;
    }

    @Override
    public User execute(Long id) {
        return this.getUserGateway.get(id);
    }
}
