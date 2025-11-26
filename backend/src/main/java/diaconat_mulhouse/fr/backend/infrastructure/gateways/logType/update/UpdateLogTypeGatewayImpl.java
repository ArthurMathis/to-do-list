package diaconat_mulhouse.fr.backend.infrastructure.gateways.logType.update;

import diaconat_mulhouse.fr.backend.application.converters.logType.jpa.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;
import diaconat_mulhouse.fr.backend.domain.repositories.LogTypeRepository;

public class UpdateLogTypeGatewayImpl implements UpdateLogTypeGateway {

    private final LogTypeRepository logTypeRepository;
    private final LogTypeJPAConverter logTypeJPAConverter;

    public UpdateLogTypeGatewayImpl(LogTypeRepository logTypeRepository,  LogTypeJPAConverter logTypeJPAConverter) {
        this.logTypeRepository = logTypeRepository;
        this.logTypeJPAConverter = logTypeJPAConverter;
    }

    @Override
    public void update(LogType logType) {
        this.logTypeRepository.save(this.logTypeJPAConverter.fromDto(logType));
    }
}
