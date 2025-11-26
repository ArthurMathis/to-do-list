package diaconat_mulhouse.fr.backend.presentation.DTOs.authentification;

import lombok.Builder;

@Builder
public record AuthToken(String token) {
}
