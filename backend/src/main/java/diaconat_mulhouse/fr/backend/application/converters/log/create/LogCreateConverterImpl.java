package diaconat_mulhouse.fr.backend.application.converters.log.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.log.CreateLogDTO;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;
import org.springframework.stereotype.Component;

@Component
public class LogCreateConverterImpl implements LogCreateConverter {

    @Override
    public Log fromDto(CreateLogDTO createLogDTO) {
        return Log.builder()
                .details(createLogDTO.details())
                .ipAddress(createLogDTO.ipAddress())
                .logTypeId(createLogDTO.logTypeId())
                .userId(createLogDTO.userId())
                .build();
    }

    @Override
    public CreateLogDTO toDto(Log log) {
        return CreateLogDTO.builder()
                .details(log.getDetails())
                .ipAddress(log.getIpAddress())
                .logTypeId(log.getLogTypeId())
                .userId(log.getUserId())
                .build();
    }
}
