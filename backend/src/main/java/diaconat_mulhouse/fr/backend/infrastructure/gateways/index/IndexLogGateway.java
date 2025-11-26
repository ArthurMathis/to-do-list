package diaconat_mulhouse.fr.backend.infrastructure.gateways.index;

import diaconat_mulhouse.fr.backend.domain.entities.log.Log;

import java.util.List;

public interface IndexLogGateway {

    /**
     * Public method that returns the list of logs
     *
     * @return The lis of logs
     */
    public List<Log> index();
}
