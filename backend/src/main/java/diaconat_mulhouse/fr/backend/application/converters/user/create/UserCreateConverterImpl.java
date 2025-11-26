package diaconat_mulhouse.fr.backend.application.converters.user.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.user.CreateUserDTO;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateConverterImpl implements UserCreateConverter {

    @Override
    public User fromDto(CreateUserDTO createUserDTO) {
        return User.builder()
                .lastName(createUserDTO.lastName())
                .firstName(createUserDTO.firstName())
                .email(createUserDTO.email())
                .password(createUserDTO.password())
                .roleId(createUserDTO.roleId())
                .establishmentsId(createUserDTO.establishmentsId())
                .build();
    }

    @Override
    public CreateUserDTO toDto(User user) {
        return CreateUserDTO.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .password(user.getPassword())
                .roleId(user.getRoleId())
                .establishmentsId(user.getEstablishmentsId())
                .build();
    }
}
