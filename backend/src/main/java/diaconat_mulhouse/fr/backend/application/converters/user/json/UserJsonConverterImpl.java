package diaconat_mulhouse.fr.backend.application.converters.user.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UserJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserJsonConverterImpl implements UserJsonConverter {

    @Override
    public User fromDto(UserJsonDTO userJsonDTO) {
        return User.builder()
                .id(userJsonDTO.id())
                .lastName(userJsonDTO.lastName())
                .firstName(userJsonDTO.firstName())
                .email(userJsonDTO.email())
                .roleId(userJsonDTO.roleId())
                .establishmentsId(userJsonDTO.establishmentsId())
                .tasksId(userJsonDTO.tasksId())
                .logsId(userJsonDTO.logsId())
                .build();
    }

    @Override
    public UserJsonDTO toDto(User user) {
        return UserJsonDTO.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .roleId(user.getRoleId())
                .establishmentsId(user.getEstablishmentsId())
                .tasksId(user.getTasksId())
                .logsId(user.getLogsId())
                .build();
    }
}
