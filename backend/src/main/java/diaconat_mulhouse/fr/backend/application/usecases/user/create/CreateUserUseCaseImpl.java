package diaconat_mulhouse.fr.backend.application.usecases.user.create;

import diaconat_mulhouse.fr.backend.core.gateways.user.create.CreateUserGateway;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public Long execute(User user) {
        return this.createUserGateway.create(user);
    }
}
