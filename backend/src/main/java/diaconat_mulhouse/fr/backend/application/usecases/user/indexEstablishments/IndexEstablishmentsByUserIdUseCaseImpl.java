package diaconat_mulhouse.fr.backend.application.usecases.user.indexEstablishments;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.indexEstablishments.IndexEstablishmentsByUserIdGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class IndexEstablishmentsByUserIdUseCaseImpl implements IndexEstablishmentsByUserIdUseCase {

    private final IndexEstablishmentsByUserIdGateway indexEstablishmentsByUserIdGateway;

    @Override
    public List<Establishment> execute(Long userId) {
        return this.indexEstablishmentsByUserIdGateway.indexEstablishment(userId);
    }
}
