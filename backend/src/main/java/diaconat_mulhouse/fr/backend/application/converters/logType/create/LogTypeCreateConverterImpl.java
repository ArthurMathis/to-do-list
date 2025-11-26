package diaconat_mulhouse.fr.backend.application.converters.logType.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.CreateLogTypeDTO;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;
import org.springframework.stereotype.Component;

@Component
public class LogTypeCreateConverterImpl implements LogTypeCreateConverter {

    @Override
    public LogType fromDto(CreateLogTypeDTO createLogTypeDTO) {
        return LogType.builder()
                .title(createLogTypeDTO.title())
                .build();
    }

    @Override
    public CreateLogTypeDTO toDto(LogType logType) {
        return CreateLogTypeDTO.builder()
                .title(logType.getTitle())
                .build();
    }
}
