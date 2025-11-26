package diaconat_mulhouse.fr.backend.application.converters.logType.jpa;

import diaconat_mulhouse.fr.backend.domain.entities.log.LogJPA;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogType;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogTypeJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.LogRepository;
import org.springframework.stereotype.Component;

@Component
public class LogTypeJPAConverterImpl implements LogTypeJPAConverter {

    private final LogRepository logRepository;

    public LogTypeJPAConverterImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public LogTypeJPA fromDto(LogType logType) {
        return LogTypeJPA.builder()
                .id(logType.getId())
                .title(logType.getTitle())
                .logs(this.logRepository.findAllById(logType.getLogsId()))
                .createdAt(logType.getCreatedAt())
                .build();
    }

    @Override
    public LogType toDto(LogTypeJPA logTypeJPA) {
        return LogType.builder()
                .id(logTypeJPA.getId())
                .title(logTypeJPA.getTitle())
                .logsId(logTypeJPA.getLogs().stream().map(LogJPA::getId).toList())
                .createdAt(logTypeJPA.getCreatedAt())
                .build();
    }

}
