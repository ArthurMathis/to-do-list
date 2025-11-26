package diaconat_mulhouse.fr.backend.application.converters.log.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.log.UpdateLogDTO;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;
import org.springframework.stereotype.Component;

@Component
public class LogUpdateConverterImpl implements LogUpdateConverter {

    @Override
    public Log fromDto(UpdateLogDTO updateLogDTO) {
        return Log.builder()
                .id(updateLogDTO.id())
                .details(updateLogDTO.details())
                .ipAddress(updateLogDTO.ipAddress())
                .logTypeId(updateLogDTO.logTypeId())
                .userId(updateLogDTO.userId())
                .build();
    }

    @Override
    public UpdateLogDTO toDto(Log log) {
        return UpdateLogDTO.builder()
                .id(log.getId())
                .details(log.getDetails())
                .ipAddress(log.getIpAddress())
                .logTypeId(log.getLogTypeId())
                .userId(log.getUserId())
                .build();
    }
}
