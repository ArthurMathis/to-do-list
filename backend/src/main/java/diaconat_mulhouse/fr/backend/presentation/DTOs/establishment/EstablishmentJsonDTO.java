package diaconat_mulhouse.fr.backend.presentation.DTOs.establishment;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record EstablishmentJsonDTO(long id, String name, String city, String postCode, List<Long> projectsId, List<Long> usersId, LocalDateTime createAt) {
}
