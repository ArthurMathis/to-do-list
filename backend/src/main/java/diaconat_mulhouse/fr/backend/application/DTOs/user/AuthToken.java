package diaconat_mulhouse.fr.backend.application.DTOs.user;

import lombok.Builder;

@Builder
public record AuthToken(String token) {
}
