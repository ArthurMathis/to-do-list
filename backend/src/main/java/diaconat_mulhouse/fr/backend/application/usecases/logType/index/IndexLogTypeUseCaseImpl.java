package diaconat_mulhouse.fr.backend.application.usecases.logType.index;

import diaconat_mulhouse.fr.backend.core.gateways.logType.index.IndexLogTypeGateway;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

import java.util.List;

public class IndexLogTypeUseCaseImpl implements IndexLogTypeUseCase {

    private final IndexLogTypeGateway indexLogTypeGateway;

    public IndexLogTypeUseCaseImpl(IndexLogTypeGateway indexLogTypeGateway) {
        this.indexLogTypeGateway = indexLogTypeGateway;
    }

    @Override
    public List<LogType> execute(Void unused) {
        return this.indexLogTypeGateway.index();
    }

}
