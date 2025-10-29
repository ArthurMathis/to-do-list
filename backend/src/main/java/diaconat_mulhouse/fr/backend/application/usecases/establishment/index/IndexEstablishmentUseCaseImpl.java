package diaconat_mulhouse.fr.backend.application.usecases.establishment.index;

import diaconat_mulhouse.fr.backend.core.gateways.establishment.index.IndexEstablishmentGateway;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

import java.util.List;

public class IndexEstablishmentUseCaseImpl implements IndexEstablishmentUseCase {

    private final IndexEstablishmentGateway indexEstablishmentGateway;

    public IndexEstablishmentUseCaseImpl(IndexEstablishmentGateway indexEstablishmentGateway) {
        this.indexEstablishmentGateway = indexEstablishmentGateway;
    }

    @Override
    public List<Establishment> execute(Void unused) {
        return this.indexEstablishmentGateway.index();
    }
}
