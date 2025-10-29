package diaconat_mulhouse.fr.backend.core.gateways.establishment.index;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

import java.util.List;

/**
 * Interface that returns the list of establishment
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface IndexEstablishmentGateway {

    /**
     * Public method that returns the list of establishment
     *
     * @return The list of establishment
     */
    public List<Establishment> index();
}
