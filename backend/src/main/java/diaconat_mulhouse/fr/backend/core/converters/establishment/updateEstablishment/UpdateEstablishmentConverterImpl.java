package diaconat_mulhouse.fr.backend.core.converters.establishment.updateEstablishment;

import diaconat_mulhouse.fr.backend.application.DTOs.establishment.UpdateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

public class UpdateEstablishmentConverterImpl implements  UpdateEstablishmentConverter {

    @Override
    public Establishment fromDto(UpdateEstablishmentDTO updateEstablishmentDTO) {
        return new Establishment(
            updateEstablishmentDTO.getId(),
            updateEstablishmentDTO.getName(),
            updateEstablishmentDTO.getAddress(),
            null
        );
    }

    @Override
    public UpdateEstablishmentDTO toDto(Establishment establishment) {
        return new UpdateEstablishmentDTO(
            establishment.getId(),
            establishment.getName(),
            establishment.getAddress()
        );
    }
}
