package diaconat_mulhouse.fr.backend.core.converters.establishment.createEstablishment;

import diaconat_mulhouse.fr.backend.application.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

public class CreateEstablishmentConverterImpl implements CreateEstablishmentConverter {

    @Override
    public Establishment fromDto(CreateEstablishmentDTO createEstablishmentDTO) {
        return new Establishment(
            0L,
            createEstablishmentDTO.getName(),
            createEstablishmentDTO.getAddress(),
            null
        );
    }

    @Override
    public CreateEstablishmentDTO toDto(Establishment establishment) {
        return new CreateEstablishmentDTO(
            establishment.getName(),
            establishment.getAddress()
        );
    }
}
