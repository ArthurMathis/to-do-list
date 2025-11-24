package diaconat_mulhouse.fr.backend.core.gateways.logType.get;

import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJPA.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;
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
