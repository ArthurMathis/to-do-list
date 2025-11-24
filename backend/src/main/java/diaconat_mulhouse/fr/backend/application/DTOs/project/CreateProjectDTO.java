package diaconat_mulhouse.fr.backend.application.DTOs.project;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CreateProjectDTO(String title, String description, long establishmentId) {
}
