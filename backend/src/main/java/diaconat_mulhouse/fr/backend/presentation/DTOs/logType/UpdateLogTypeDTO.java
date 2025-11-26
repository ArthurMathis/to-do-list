package diaconat_mulhouse.fr.backend.presentation.DTOs.logType;

import lombok.Builder;

@Builder
public record UpdateLogTypeDTO(long id, String title) {
}
