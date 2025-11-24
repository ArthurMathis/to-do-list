package diaconat_mulhouse.fr.backend.application.DTOs.establishment;

import lombok.Builder;

import java.util.List;

@Builder
public record UpdateEstablishmentDTO(long id, String name, String city, String postCode, List<Long> projectsId, List<Long> usersId) {
}
