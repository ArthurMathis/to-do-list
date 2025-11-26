package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;

/**
 * Interface that returns an establishment
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface GetEstablishmentGateway {

    /**
     * Public method that returns an establishment from its primary key
     *
     * @param id Its primary key
     * @return The establishment
     */
    public Establishment get(long id);
}
