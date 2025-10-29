package diaconat_mulhouse.fr.backend.application.usecases.user.index;

import diaconat_mulhouse.fr.backend.core.gateways.user.index.IndexUserGateway;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

import java.util.List;

public class IndexUserUseCaseImpl implements IndexUserUseCase {

    private final IndexUserGateway indexUserGateway;

    public IndexUserUseCaseImpl(IndexUserGateway indexUserGateway) {
        this.indexUserGateway = indexUserGateway;
    }

    @Override
    public List<User> execute(Void unused) {
        return this.indexUserGateway.index();
    }
}
