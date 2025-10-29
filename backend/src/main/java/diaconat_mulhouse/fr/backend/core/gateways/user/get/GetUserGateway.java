package diaconat_mulhouse.fr.backend.core.gateways.user.get;

import diaconat_mulhouse.fr.backend.domain.entities.User.User;

/**
 * Interface that returns a user from his primary key
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface GetUserGateway {

    /**
     * Public method that returns a user from his primary key
     *
     * @param id His primary key
     * @return The user
     */
    public User get(long id);

}
