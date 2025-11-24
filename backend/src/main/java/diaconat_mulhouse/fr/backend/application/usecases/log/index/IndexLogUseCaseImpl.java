package diaconat_mulhouse.fr.backend.application.usecases.log.index;

import diaconat_mulhouse.fr.backend.core.gateways.log.index.IndexLogGateway;
import diaconat_mulhouse.fr.backend.domain.entities.Log.Log;

import java.util.List;

public class IndexLogUseCaseImpl implements IndexLogUseCase {

    private final IndexLogGateway indexLogGateway;

    public IndexLogUseCaseImpl(IndexLogGateway indexLogGateway) {
        this.indexLogGateway = indexLogGateway;
    }

    @Override
    public List<Log> execute(Void unused) {
        return this.indexLogGateway.index();
    }
}
