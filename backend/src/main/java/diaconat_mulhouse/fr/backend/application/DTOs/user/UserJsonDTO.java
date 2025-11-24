package diaconat_mulhouse.fr.backend.application.DTOs.user;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record UserJsonDTO(long id, String lastName, String firstName, String email,
                          long roleId, List<Long> establishmentsId, List<Long> tasksId,
                          List<Long> logsId, LocalDateTime createdAt) {
}
