package diaconat_mulhouse.fr.backend.core.gateways.logType.update;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

public interface UpdateLogTypeGateway {

    /**
     * Public method that updates a log type
     *
     * @param logType The log type
     */
    public void update(LogType logType);

}
