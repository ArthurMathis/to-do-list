package diaconat_mulhouse.fr.backend.application.converters.user.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UpdateUserDTO;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateConverterImpl implements UserUpdateConverter {

    @Override
    public User fromDto(UpdateUserDTO updateUserDTO) {
        return User.builder()
                .id(updateUserDTO.id())
                .lastName(updateUserDTO.lastName())
                .firstName(updateUserDTO.firstName())
                .email(updateUserDTO.email())
                .password(updateUserDTO.password())
                .roleId(updateUserDTO.roleId())
                .establishmentsId(updateUserDTO.establishmentsId())
                .tasksId(updateUserDTO.tasksId())
                .build();
    }

    @Override
    public UpdateUserDTO toDto(User user) {
        return UpdateUserDTO.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .password(user.getPassword())
                .roleId(user.getRoleId())
                .establishmentsId(user.getEstablishmentsId())
                .tasksId(user.getTasksId())
                .build();
    }
}
