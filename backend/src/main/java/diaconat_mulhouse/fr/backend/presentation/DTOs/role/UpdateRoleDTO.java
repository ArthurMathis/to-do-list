package diaconat_mulhouse.fr.backend.presentation.DTOs.role;

import lombok.Builder;

@Builder
public record UpdateRoleDTO(Long id, String title) {
}
