package diaconat_mulhouse.fr.backend.presentation.DTOs.establishment;

import lombok.Builder;

@Builder
public record CreateEstablishmentDTO(String name, String city, String postCode) {
}
