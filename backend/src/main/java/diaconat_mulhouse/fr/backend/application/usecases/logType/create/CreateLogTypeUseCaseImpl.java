package diaconat_mulhouse.fr.backend.application.usecases.logType.create;

import diaconat_mulhouse.fr.backend.core.gateways.logType.create.CreateLogTypeGateway;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

public class CreateLogTypeUseCaseImpl implements CreateLogTypeUseCase {

    private final CreateLogTypeGateway logTypeGateway;

    public CreateLogTypeUseCaseImpl(CreateLogTypeGateway logTypeGateway) {
        this.logTypeGateway = logTypeGateway;
    }

    @Override
    public Long execute(LogType logType) {
        return this.logTypeGateway.create(logType);
    }
}
