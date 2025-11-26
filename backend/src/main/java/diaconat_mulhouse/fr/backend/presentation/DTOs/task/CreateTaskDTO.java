package diaconat_mulhouse.fr.backend.presentation.DTOs.task;

import lombok.Builder;

@Builder
public record CreateTaskDTO(String title, String description, long projectId) {
}
