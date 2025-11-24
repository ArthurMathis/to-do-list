package diaconat_mulhouse.fr.backend.application.DTOs.log;

import lombok.Builder;

import java.util.HashMap;

@Builder
public record CreateLogDTO(long logTypeId, long userId, HashMap<String, String> details, String ipAddress) {
}
