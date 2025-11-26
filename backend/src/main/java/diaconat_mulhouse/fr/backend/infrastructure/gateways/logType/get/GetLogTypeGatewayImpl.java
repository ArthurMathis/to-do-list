package diaconat_mulhouse.fr.backend.infrastructure.gateways.logType.get;

import diaconat_mulhouse.fr.backend.application.converters.logType.jpa.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;
import diaconat_mulhouse.fr.backend.domain.repositories.LogTypeRepository;
import jakarta.persistence.EntityNotFoundException;

public class GetLogTypeGatewayImpl implements GetLogTypeGateway {

    private final LogTypeRepository logTypeRepository;
    private final LogTypeJPAConverter logTypeJPAConverter;

    public GetLogTypeGatewayImpl(LogTypeRepository logTypeRepository,  LogTypeJPAConverter logTypeJPAConverter) {
        this.logTypeRepository = logTypeRepository;
        this.logTypeJPAConverter = logTypeJPAConverter;
    }

    @Override
    public LogType get(Long id) {
        return this.logTypeJPAConverter.toDto(this.logTypeRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("LogType not found with id: " + id);
        }));
    }
}
