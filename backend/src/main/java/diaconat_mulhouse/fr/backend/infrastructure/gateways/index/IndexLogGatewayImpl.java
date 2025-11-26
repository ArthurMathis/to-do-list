package diaconat_mulhouse.fr.backend.infrastructure.gateways.index;

import diaconat_mulhouse.fr.backend.application.converters.log.jpa.LogJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;
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
