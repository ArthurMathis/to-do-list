package diaconat_mulhouse.fr.backend.core.converters.user.updateUser;

import diaconat_mulhouse.fr.backend.application.DTOs.user.UpdateUserDTO;
import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

public class UpdateUserConverterImpl implements UpdateUserConverter {

    private final EstablishmentService establishmentService;
    private final EstablishmentJsonConverter establishmentJsonConverter;

    public UpdateUserConverterImpl(EstablishmentService establishmentService, EstablishmentJsonConverter establishmentJsonConverter) {
        this.establishmentService = establishmentService;
        this.establishmentJsonConverter = establishmentJsonConverter;
    }

    @Override
    public User fromDto(UpdateUserDTO updateUserDTO) {
        return new User(
            updateUserDTO.getId(),
            updateUserDTO.getLastName(),
            updateUserDTO.getFirstName(),
            updateUserDTO.getEmail(),
            updateUserDTO.getPassword(),
            updateUserDTO.getEstablishmentsId().stream().map((obj) -> {
                return this.establishmentJsonConverter.fromDto(this.establishmentService.get(obj));
            }).toList(),
            null
        );
    }

    @Override
    public UpdateUserDTO toDto(User user) {
        return new UpdateUserDTO(
            user.getId(),
            user.getLastName(),
            user.getFirstName(),
            user.getEmail(),
            user.getPassword(),
            user.getEstablishments().stream().map(Establishment::getId).toList()
        );
    }
}
