package diaconat_mulhouse.fr.backend.core.gateways.logType.get;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

public interface GetLogTypeGateway {

    /**
     * Publci method that returns a log type from its primary key
     *
     * @param id The primary key
     * @return The log type
     */
    public LogType get(Long id);

}
