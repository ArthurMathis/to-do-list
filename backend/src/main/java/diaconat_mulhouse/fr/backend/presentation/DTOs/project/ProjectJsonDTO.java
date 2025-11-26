package diaconat_mulhouse.fr.backend.presentation.DTOs.project;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ProjectJsonDTO(long id, String title, String description, long establishmentId, List<Long> tasksId, LocalDateTime createdAt) {
}
