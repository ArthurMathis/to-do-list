package diaconat_mulhouse.fr.backend.application.DTOs.role;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record RoleJsonDTO(long id, String title, List<Long> usersId, LocalDateTime createAt) {
}
