package diaconat_mulhouse.fr.backend.application.DTOs.task;

import lombok.Builder;

@Builder
public record CreateTaskDTO(String title, String description, long projectId) {
}
