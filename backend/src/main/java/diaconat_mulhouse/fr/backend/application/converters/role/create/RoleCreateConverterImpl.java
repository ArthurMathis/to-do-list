package diaconat_mulhouse.fr.backend.application.converters.role.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.role.CreateRoleDTO;
import diaconat_mulhouse.fr.backend.domain.entities.role.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleCreateConverterImpl implements RoleCreateConverter {

    @Override
    public Role fromDto(CreateRoleDTO createRoleDTO) {
        return Role.builder()
                .title(createRoleDTO.title())
                .build();
    }

    @Override
    public CreateRoleDTO toDto(Role role) {
        return CreateRoleDTO.builder()
                .title(role.getTitle())
                .build();
    }
}
