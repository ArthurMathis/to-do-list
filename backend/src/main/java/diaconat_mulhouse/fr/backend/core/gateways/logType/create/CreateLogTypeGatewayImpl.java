package diaconat_mulhouse.fr.backend.core.gateways.logType.create;

import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJPA.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;
import diaconat_mulhouse.fr.backend.domain.repositories.LogTypeRepository;

public class CreateLogTypeGatewayImpl implements CreateLogTypeGateway {

    private final LogTypeRepository logTypeRepository;
    private final LogTypeJPAConverter logTypeJPAConverter;

    public CreateLogTypeGatewayImpl(LogTypeRepository logTypeRepository,  LogTypeJPAConverter logTypeJPAConverter) {
        this.logTypeRepository = logTypeRepository;
        this.logTypeJPAConverter = logTypeJPAConverter;
    }

    @Override
    public Long create(LogType logType) {
        return this.logTypeRepository.save(this.logTypeJPAConverter.fromDto(logType)).getId();
    }
}
