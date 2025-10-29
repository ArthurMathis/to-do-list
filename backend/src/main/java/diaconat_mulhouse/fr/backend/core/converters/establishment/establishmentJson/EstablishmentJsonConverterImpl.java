package diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson;

import diaconat_mulhouse.fr.backend.application.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;

public class EstablishmentJsonConverterImpl implements EstablishmentJsonConverter {

    @Override
    public Establishment fromDto(EstablishmentJsonDTO establishmentJsonDTO) {
        return new Establishment(
            establishmentJsonDTO.getId(),
            establishmentJsonDTO.getName(),
            establishmentJsonDTO.getAddress(),
            establishmentJsonDTO.getCreateAt()
        );
    }

    @Override
    public EstablishmentJsonDTO toDto(Establishment establishment) {
        return new  EstablishmentJsonDTO(
            establishment.getId(),
            establishment.getName(),
            establishment.getAddress(),
            establishment.getCreatedAt()
        );
    }
}
