package diaconat_mulhouse.fr.backend.core.gateways.logType.update;

import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJPA.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;
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
