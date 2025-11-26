package diaconat_mulhouse.fr.backend.application.converters.log.jpa;

import diaconat_mulhouse.fr.backend.application.converters.map.MapConverter;
import diaconat_mulhouse.fr.backend.domain.entities.log.Log;
import diaconat_mulhouse.fr.backend.domain.entities.log.LogJPA;
import diaconat_mulhouse.fr.backend.domain.entities.logType.LogTypeJPA;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.LogTypeRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LogJPAConverterImpl implements LogJPAConverter {

    private final LogTypeRepository logTypeRepository;
    private final UserRepository userRepository;
    private final MapConverter mapConverter;

    public LogJPAConverterImpl(LogTypeRepository logTypeRepository, UserRepository userRepository, MapConverter mapConverter) {
        this.logTypeRepository = logTypeRepository;
        this.userRepository = userRepository;
        this.mapConverter = mapConverter;
    }

    @Override
    public LogJPA fromDto(Log log) {
        LogTypeJPA logTypeJPA = this.logTypeRepository.findById(log.getLogTypeId()).orElseThrow(
            () -> new EntityNotFoundException("Log Type : " + log.getLogTypeId() + ", Not Found")
        );
        UserJPA userJPA = this.userRepository.findById(log.getUserId()).orElseThrow(
            () -> new EntityNotFoundException("User : " + log.getUserId() + ", Not Found")
        );

        return LogJPA.builder()
                .id(log.getId())
                .details(this.mapConverter.fromDto(log.getDetails()))
                .ipAddress(log.getIpAddress())
                .logType(logTypeJPA)
                .user(userJPA)
                .createdAt(log.getCreatedAt())
                .build();
    }

    @Override
    public Log toDto(LogJPA logJPA) {
        return Log.builder()
                .id(logJPA.getId())
                .details(this.mapConverter.toDto(logJPA.getDetails()))
                .ipAddress(logJPA.getIpAddress())
                .logTypeId(logJPA.getLogType().getId())
                .userId(logJPA.getUser().getId())
                .createdAt(logJPA.getCreatedAt())
                .build();
    }
}
