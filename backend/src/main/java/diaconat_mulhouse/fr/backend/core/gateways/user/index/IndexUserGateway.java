package diaconat_mulhouse.fr.backend.core.gateways.user.index;

import diaconat_mulhouse.fr.backend.domain.entities.User.User;

import java.util.List;

/**
 * Interface that returns the list of users
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface IndexUserGateway {

    /**
     * Public method that returns the list of users
     *
     * @return The list of users
     */
    public List<User> index();

}
