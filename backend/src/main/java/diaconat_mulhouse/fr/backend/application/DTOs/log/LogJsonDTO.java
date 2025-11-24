package diaconat_mulhouse.fr.backend.application.DTOs.log;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.HashMap;

@Builder
public record LogJsonDTO(long id, HashMap<String, String> details, String ipAddress, long logTypeId, long userId, LocalDateTime createdAt) {
}
