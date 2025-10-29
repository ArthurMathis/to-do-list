package diaconat_mulhouse.fr.backend.core.converters.user.createUser;

import diaconat_mulhouse.fr.backend.application.DTOs.user.CreateUserDTO;
import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUserConverterImpl implements CreateUserConverter {

    private final EstablishmentService establishmentService;
    private final EstablishmentJsonConverter establishmentJsonConverter;
    private final PasswordEncoder passwordEncoder;

    public CreateUserConverterImpl(
            EstablishmentService establishmentService,
            EstablishmentJsonConverter establishmentJsonConverter,
            PasswordEncoder passwordEncoder
    ) {
        this.establishmentService = establishmentService;
        this.establishmentJsonConverter = establishmentJsonConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User fromDto(CreateUserDTO createUserDTO) {
        return new User(
            0L,
            createUserDTO.getLastName(),
            createUserDTO.getFirstName(),
            createUserDTO.getEmail(),
            this.passwordEncoder.encode(createUserDTO.getPassword()),
            createUserDTO.getEstablishmentsId().stream().map((obj) -> {
                return this.establishmentJsonConverter.fromDto(this.establishmentService.get(obj));
            }).toList(),
            null
        );
    }

    @Override
    public CreateUserDTO toDto(User user) {
        return new CreateUserDTO(
            user.getLastName(),
            user.getFirstName(),
            user.getEmail(),
            user.getPassword(),
            user.getEstablishments().stream().map(Establishment::getId).toList()
        );
    }
}
