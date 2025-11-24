package diaconat_mulhouse.fr.backend.core.gateways.logType.delete;

public interface DeleteLogTypeGateway {

    /**
     * Public method that deletes a log type from its primary key
     *
     * @param id The primary key
     */
    public void delete(Long id);

}
