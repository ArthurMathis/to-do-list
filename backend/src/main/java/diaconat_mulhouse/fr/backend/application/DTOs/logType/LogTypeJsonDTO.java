package diaconat_mulhouse.fr.backend.application.DTOs.logType;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record LogTypeJsonDTO(long id, String title, List<Long> logsId, LocalDateTime createdAt) {
}
