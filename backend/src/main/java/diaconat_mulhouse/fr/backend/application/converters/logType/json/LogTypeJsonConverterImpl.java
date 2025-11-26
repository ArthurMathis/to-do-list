package diaconat_mulhouse.fr.backend.application.converters.logType.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.LogTypeJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;
import org.springframework.stereotype.Component;

@Component
public class LogTypeJsonConverterImpl implements LogTypeJsonConverter {

    @Override
    public LogType fromDto(LogTypeJsonDTO logTypeJsonDTO) {
        return LogType.builder()
                .id(logTypeJsonDTO.id())
                .title(logTypeJsonDTO.title())
                .logsId(logTypeJsonDTO.logsId())
                .build();
    }

    @Override
    public LogTypeJsonDTO toDto(LogType logType) {
        return LogTypeJsonDTO.builder()
                .id(logType.getId())
                .title(logType.getTitle())
                .logsId(logType.getLogsId())
                .build();
    }

}
