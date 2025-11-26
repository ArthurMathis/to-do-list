package diaconat_mulhouse.fr.backend.application.converters.role.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.role.CreateRoleDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.role.Role;

public interface RoleCreateConverter extends Converter<CreateRoleDTO, Role> {
}
