package diaconat_mulhouse.fr.backend.presentation.DTOs.task;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record TaskJsonDTO(long id, String title, String description, boolean checked, long projectId, List<Long> usersId, LocalDateTime createdAt) {
}
