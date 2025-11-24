package diaconat_mulhouse.fr.backend.core.gateways.logType.create;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

public interface CreateLogTypeGateway {

    /**
     * Public method that creates a new log type
     *
     * @param logType The log type to register
     * @return Its primary key
     */
     public Long create(LogType logType);

}
