package diaconat_mulhouse.fr.backend.infrastructure.gateways.user.delete;

/**
 * Interface that deletes a user from his primary key
 */
public interface DeleteUserGateway {

    /**
     * Public method that deletes a user from his primary key
     *
     * @param id His primary key
     */
    public void delete(long id);
}
