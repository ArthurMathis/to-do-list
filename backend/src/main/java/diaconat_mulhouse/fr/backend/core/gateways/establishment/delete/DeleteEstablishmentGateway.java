package diaconat_mulhouse.fr.backend.core.gateways.establishment.delete;

/**
 * Interface that deletes an establishment
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface DeleteEstablishmentGateway {

    /**
     * Public method that deletes the establishment from its primary key
     *
     * @param id Its primary key
     */
    public void delete(long id);
}
