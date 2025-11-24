package diaconat_mulhouse.fr.backend.application.DTOs.log;

import lombok.Builder;

import java.util.HashMap;

@Builder
public record UpdateLogDTO (long id, HashMap<String, String> details,  String ipAddress, long logTypeId, long userId) {
}
