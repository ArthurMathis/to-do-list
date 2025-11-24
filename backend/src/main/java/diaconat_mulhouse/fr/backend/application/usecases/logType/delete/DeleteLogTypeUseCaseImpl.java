package diaconat_mulhouse.fr.backend.application.usecases.logType.delete;

import diaconat_mulhouse.fr.backend.core.gateways.logType.delete.DeleteLogTypeGateway;

public class DeleteLogTypeUseCaseImpl implements DeleteLogTypeUseCase {

    private final DeleteLogTypeGateway deleteLogTypeGateway;

    public DeleteLogTypeUseCaseImpl(DeleteLogTypeGateway deleteLogTypeGateway) {
        this.deleteLogTypeGateway = deleteLogTypeGateway;
    }

    @Override
    public Void execute(Long aLong) {
        this.deleteLogTypeGateway.delete(aLong);
        return null;
    }
}
