package diaconat_mulhouse.fr.backend.application.converters.log.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.log.LogJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;
import org.springframework.stereotype.Component;

@Component
public class LogJsonConverterImpl implements LogJsonConverter {

    @Override
    public Log fromDto(LogJsonDTO logJsonDTO) {
        return Log.builder()
                .id(logJsonDTO.id())
                .details(logJsonDTO.details())
                .ipAddress(logJsonDTO.ipAddress())
                .logTypeId(logJsonDTO.logTypeId())
                .userId(logJsonDTO.userId())
                .createdAt(logJsonDTO.createdAt())
                .build();
    }

    @Override
    public LogJsonDTO toDto(Log log) {
        return LogJsonDTO.builder()
                .id(log.getId())
                .details(log.getDetails())
                .ipAddress(log.getIpAddress())
                .logTypeId(log.getLogTypeId())
                .userId(log.getUserId())
                .createdAt(log.getCreatedAt())
                .build();
    }
}
