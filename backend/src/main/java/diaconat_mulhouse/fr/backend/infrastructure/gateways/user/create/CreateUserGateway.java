package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.create;

import diaconat_mulhouse.fr.backend.domain.entities.user.User;

/**
 * Interface that creates a user
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface CreateUserGateway {

    /**
     * Public method that creates a user
     *
     * @param user The user entity that contains the user's pîeces of information
     * @return The user's primary
     */
    public long create(User user);

}
