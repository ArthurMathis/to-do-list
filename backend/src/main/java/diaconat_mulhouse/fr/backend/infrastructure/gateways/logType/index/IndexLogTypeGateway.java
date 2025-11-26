package diaconat_mulhouse.fr.backend.infrastructure.gateways.logType.index;

import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;

import java.util.List;

public interface IndexLogTypeGateway {

    /**
     * Public method that returns the list of log type
     *
     * @return The list of log type
     */
    public List<LogType> index();

}
