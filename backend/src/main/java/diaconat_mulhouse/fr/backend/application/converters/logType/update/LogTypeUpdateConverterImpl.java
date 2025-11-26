package diaconat_mulhouse.fr.backend.application.converters.logType.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.logType.UpdateLogTypeDTO;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;
import org.springframework.stereotype.Component;

@Component
public class LogTypeUpdateConverterImpl implements LogTypeUpdateConverter {

    @Override
    public LogType fromDto(UpdateLogTypeDTO updateLogTypeDTO) {
        return LogType.builder()
                .id(updateLogTypeDTO.id())
                .title(updateLogTypeDTO.title())
                .build();
    }

    @Override
    public UpdateLogTypeDTO toDto(LogType logType) {
        return UpdateLogTypeDTO.builder()
                .id(logType.getId())
                .title(logType.getTitle())
                .build();
    }
}
