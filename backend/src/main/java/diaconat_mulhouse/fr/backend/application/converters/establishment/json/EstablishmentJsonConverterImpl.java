package diaconat_mulhouse.fr.backend.application.converters.establishment.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import org.springframework.stereotype.Component;

@Component
public class EstablishmentJsonConverterImpl implements EstablishmentJsonConverter {

    @Override
    public Establishment fromDto(EstablishmentJsonDTO establishmentJsonDTO) {
        return Establishment.builder()
                .id(establishmentJsonDTO.id())
                .name(establishmentJsonDTO.name())
                .city(establishmentJsonDTO.city())
                .postCode(establishmentJsonDTO.postCode())
                .usersId(establishmentJsonDTO.usersId())
                .projectsId(establishmentJsonDTO.projectsId())
                .createdAt(establishmentJsonDTO.createAt())
                .build();
    }

    @Override
    public EstablishmentJsonDTO toDto(Establishment establishment) {
        return EstablishmentJsonDTO.builder()
                .id(establishment.getId())
                .name(establishment.getName())
                .city(establishment.getCity())
                .postCode(establishment.getPostCode())
                .usersId(establishment.getUsersId())
                .projectsId(establishment.getProjectsId())
                .createAt(establishment.getCreatedAt())
                .build();
    }
}
