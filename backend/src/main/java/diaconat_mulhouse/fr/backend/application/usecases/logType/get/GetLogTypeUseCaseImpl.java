package diaconat_mulhouse.fr.backend.application.usecases.logType.get;

import diaconat_mulhouse.fr.backend.core.gateways.logType.get.GetLogTypeGateway;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

public class GetLogTypeUseCaseImpl implements GetLogTypeUseCase {

    private final GetLogTypeGateway getLogTypeGateway;

    public GetLogTypeUseCaseImpl(GetLogTypeGateway getLogTypeGateway) {
        this.getLogTypeGateway = getLogTypeGateway;
    }

    @Override
    public LogType execute(Long aLong) {
        return this.getLogTypeGateway.get(aLong);
    }
}
