package diaconat_mulhouse.fr.backend.application.DTOs.role;

import lombok.Builder;

@Builder
public record UpdateRoleDTO(Long id, String title) {
}
