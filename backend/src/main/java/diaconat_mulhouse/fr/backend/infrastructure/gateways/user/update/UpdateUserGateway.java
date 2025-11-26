package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.update;

import diaconat_mulhouse.fr.backend.domain.entities.user.User;

/**
 * Interface that updates a user
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface UpdateUserGateway {

    /**
     * Public method that updates a user
     *
     * @param user The entity that contains the user's new pieces of information
     */
    public void udapte(User user);
}
