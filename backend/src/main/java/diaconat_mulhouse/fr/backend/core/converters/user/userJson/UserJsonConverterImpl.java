package diaconat_mulhouse.fr.backend.core.converters.user.userJson;

import diaconat_mulhouse.fr.backend.application.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.user.UserJsonDTO;
import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

public class UserJsonConverterImpl implements UserJsonConverter {

    private final EstablishmentService establishmentService;
    private final EstablishmentJsonConverter establishmentJsonConverter;

    public UserJsonConverterImpl(EstablishmentService establishmentService, EstablishmentJsonConverter establishmentJsonConverter) {
        this.establishmentService = establishmentService;
        this.establishmentJsonConverter = establishmentJsonConverter;
    }

    @Override
    public User fromDto(UserJsonDTO userJsonDTO) {
        return new User(
            userJsonDTO.getId(),
            userJsonDTO.getFirstName(),
            userJsonDTO.getLastName(),
            userJsonDTO.getEmail(),
            userJsonDTO.getPassword(),
            userJsonDTO.getEstablishmentsId().stream().map((obj) -> {
                EstablishmentJsonDTO fetchEstablishment = this.establishmentService.get(obj);
                return this.establishmentJsonConverter.fromDto(fetchEstablishment);
            }).toList(),
            userJsonDTO.getCreatedAt()
        );
    }

    @Override
    public UserJsonDTO toDto(User user) {
        return new UserJsonDTO(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPassword(),
            user.getEstablishments().stream().map(Establishment::getId).toList(),
            user.getCreatedAt()
        );
    }
}
