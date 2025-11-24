package diaconat_mulhouse.fr.backend.core.gateways.log.index;

import diaconat_mulhouse.fr.backend.core.converters.log.logJPAConverter.LogJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Log.Log;
import diaconat_mulhouse.fr.backend.domain.repositories.LogRepository;

import java.util.List;

public class IndexLogGatewayImpl implements IndexLogGateway {

    private final LogRepository logRepository;
    private final LogJPAConverter logJPAConverter;

    public IndexLogGatewayImpl(LogRepository logRepository,  LogJPAConverter logJPAConverter) {
        this.logRepository = logRepository;
        this.logJPAConverter = logJPAConverter;
    }

    @Override
    public List<Log> index() {
        return this.logRepository.findAll().stream().map(this.logJPAConverter::toDto).toList();
    }
}
