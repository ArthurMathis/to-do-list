package diaconat_mulhouse.fr.backend.application.converters.establishment.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.UpdateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import org.springframework.stereotype.Component;

@Component
public class EstablishmentUpdateConverterImpl implements EstablishmentUpdateConverter {

    @Override
    public Establishment fromDto(UpdateEstablishmentDTO updateEstablishmentDTO) {
        return Establishment.builder()
                .id(updateEstablishmentDTO.id())
                .name(updateEstablishmentDTO.name())
                .city(updateEstablishmentDTO.city())
                .postCode(updateEstablishmentDTO.postCode())
                .usersId(updateEstablishmentDTO.usersId())
                .projectsId(updateEstablishmentDTO.projectsId())
                .build();
    }

    @Override
    public UpdateEstablishmentDTO toDto(Establishment establishment) {
        return UpdateEstablishmentDTO.builder()
                .id(establishment.getId())
                .name(establishment.getName())
                .city(establishment.getCity())
                .postCode(establishment.getPostCode())
                .usersId(establishment.getUsersId())
                .projectsId(establishment.getProjectsId())
                .build();
    }
}
