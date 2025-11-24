package diaconat_mulhouse.fr.backend.core.gateways.logType.index;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;

import java.util.List;

public interface IndexLogTypeGateway {

    /**
     * Public method that returns the list of log type
     *
     * @return The list of log type
     */
    public List<LogType> index();

}
