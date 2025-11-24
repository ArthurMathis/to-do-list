package diaconat_mulhouse.fr.backend.application.DTOs.logType;

import lombok.Builder;

@Builder
public record UpdateLogTypeDTO(long id, String title) {
}
