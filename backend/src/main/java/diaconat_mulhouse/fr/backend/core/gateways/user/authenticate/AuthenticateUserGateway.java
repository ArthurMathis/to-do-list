package diaconat_mulhouse.fr.backend.core.gateways.user.authenticate;

import diaconat_mulhouse.fr.backend.domain.entities.User.User;

/**
 * Interface that returns a user from his email
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface AuthenticateUserGateway {

    /**
     * Public method that a user from his email
     *
     * @param email The searched email
     * @return The user
     */
    public User getByEmail(String email);
}
