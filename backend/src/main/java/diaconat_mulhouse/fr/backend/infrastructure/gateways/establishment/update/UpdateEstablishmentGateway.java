package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.update;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;

/**
 * Interface that updates an establishment
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface UpdateEstablishmentGateway {

    /**
     * Public method that updates an establishment
     *
     * @param establishment The entity that contains the pieces of information of the establishment
     */
    public void udapte(Establishment establishment);
}
