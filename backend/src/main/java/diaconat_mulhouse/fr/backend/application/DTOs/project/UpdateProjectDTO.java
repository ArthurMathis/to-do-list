package diaconat_mulhouse.fr.backend.application.DTOs.project;

import lombok.Builder;

import java.util.List;

@Builder
public record UpdateProjectDTO(long id, String title, String description, long establishmentId, List<Long> tasksId) {
}
