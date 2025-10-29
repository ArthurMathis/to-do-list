package diaconat_mulhouse.fr.backend.core.gateways.establishment.create;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

/**
 * Interface that creates a new establishment
 *
 * @author Arthur MATHIS - arthur.mahis@diaconat-mulhouse.fr
 */
public interface CreateEstablishmentGateway {

    /**
     * Public method that creates a new establishment
     *
     * @param establishment The entity that contains the pieces of information of the new establishment
     * @return The primary key of the new establishment
     */
    public long create(Establishment establishment);
}
