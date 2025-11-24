package diaconat_mulhouse.fr.backend.core.gateways.logType.index;

import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJPA.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;
import diaconat_mulhouse.fr.backend.domain.repositories.LogTypeRepository;

import java.util.List;

public class IndexLogTypeGatewayImpl implements IndexLogTypeGateway {

    private final LogTypeRepository logTypeRepository;
    public final LogTypeJPAConverter logTypeJPAConverter;

    public IndexLogTypeGatewayImpl(LogTypeRepository logTypeRepository, LogTypeJPAConverter logTypeJPAConverter) {
        this.logTypeRepository = logTypeRepository;
        this.logTypeJPAConverter = logTypeJPAConverter;
    }

    @Override
    public List<LogType> index() {
        return this.logTypeRepository.findAll().stream().map(this.logTypeJPAConverter::toDto).toList();
    }

}
