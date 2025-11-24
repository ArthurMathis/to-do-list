package diaconat_mulhouse.fr.backend.application.usecases.logType.update;

import diaconat_mulhouse.fr.backend.core.gateways.logType.update.UpdateLogTypeGateway;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

public class UpdateLogTypeUseCaseImpl implements UpdateLogTypeUseCase {

    private final UpdateLogTypeGateway updateLogTypeGateway;

    public UpdateLogTypeUseCaseImpl(UpdateLogTypeGateway updateLogTypeGateway) {
        this.updateLogTypeGateway = updateLogTypeGateway;
    }

    @Override
    public Void execute(LogType logType) {
        this.updateLogTypeGateway.update(logType);
        return null;
    }
}
