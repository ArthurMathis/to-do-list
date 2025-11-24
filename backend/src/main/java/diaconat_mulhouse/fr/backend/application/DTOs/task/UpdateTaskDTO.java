package diaconat_mulhouse.fr.backend.application.DTOs.task;

import lombok.Builder;

import java.util.List;

@Builder
public record UpdateTaskDTO(long id, String title, String description, boolean checked, long projectId, List<Long> usersId) {
}
