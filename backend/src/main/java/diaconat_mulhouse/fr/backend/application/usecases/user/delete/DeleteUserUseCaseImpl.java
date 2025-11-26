package diaconat_mulhouse.fr.backend.application.usecases.user.delete;

import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.delete.DeleteUserGateway;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final DeleteUserGateway deleteUserGateway;

    public DeleteUserUseCaseImpl(DeleteUserGateway deleteUserGateway) {
        this.deleteUserGateway = deleteUserGateway;
    }

    @Override
    public Void execute(Long aLong) {
        this.deleteUserGateway.delete(aLong);
        return null;
    }
}
