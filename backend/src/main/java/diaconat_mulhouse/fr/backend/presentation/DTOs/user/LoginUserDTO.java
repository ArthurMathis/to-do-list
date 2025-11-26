package diaconat_mulhouse.fr.backend.presentation.DTOs.user;

import lombok.Builder;

@Builder
public record LoginUserDTO(String email, String password) {
}
