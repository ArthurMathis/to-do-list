package diaconat_mulhouse.fr.backend.application.converters.role.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.role.RoleJsonDTO;
import diaconat_mulhouse.fr.backend.domain.entities.role.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleJsonConverterImpl implements RoleJsonConverter {

    @Override
    public Role fromDto(RoleJsonDTO roleJsonDTO) {
        return Role.builder()
                .id(roleJsonDTO.id())
                .title(roleJsonDTO.title())
                .usersId(roleJsonDTO.usersId())
                .createdAt(roleJsonDTO.createAt())
                .build();
    }

    @Override
    public RoleJsonDTO toDto(Role role) {
        return RoleJsonDTO.builder()
                .id(role.getId())
                .title(role.getTitle())
                .usersId(role.getUsersId())
                .createAt(role.getCreatedAt())
                .build();
    }
}
