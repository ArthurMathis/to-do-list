package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.indexEstablishments;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;

import java.util.List;

public interface IndexEstablishmentsByUserIdGateway {

    /**
     * Public method that returns the user's list of establishments
     *
     * @param userId The user's primary key
     * @return The user's list of establishments
     */
    public List<Establishment> indexEstablishment(long userId);

}
