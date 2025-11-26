package diaconat_mulhouse.fr.backend.application.converters.establishment.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import org.springframework.stereotype.Component;

@Component
public class EstablishmentCreateConverterImpl implements EstablishmentCreateConverter {

    @Override
    public Establishment fromDto(CreateEstablishmentDTO createEstablishmentDTO) {
        return Establishment.builder()
                .name(createEstablishmentDTO.name())
                .city(createEstablishmentDTO.city())
                .postCode((createEstablishmentDTO.postCode()))
                .build();
    }

    @Override
    public CreateEstablishmentDTO toDto(Establishment establishment) {
        return CreateEstablishmentDTO.builder()
                .name(establishment.getName())
                .city(establishment.getCity())
                .postCode(establishment.getPostCode())
                .build();
    }
}
