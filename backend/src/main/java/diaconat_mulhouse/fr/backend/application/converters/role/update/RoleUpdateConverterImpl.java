package diaconat_mulhouse.fr.backend.application.converters.role.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.role.UpdateRoleDTO;
import diaconat_mulhouse.fr.backend.domain.entities.role.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleUpdateConverterImpl implements RoleUpdateConverter {

    @Override
    public Role fromDto(UpdateRoleDTO updateRoleDTO) {
        return Role.builder()
                .id(updateRoleDTO.id())
                .title(updateRoleDTO.title())
                .build();
    }

    @Override
    public UpdateRoleDTO toDto(Role role) {
        return UpdateRoleDTO.builder()
                .id(role.getId())
                .title(role.getTitle())
                .build();
    }
}
