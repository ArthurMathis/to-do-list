package diaconat_mulhouse.fr.backend.application.converters.role.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.role.UpdateRoleDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.role.Role;

public interface RoleUpdateConverter extends Converter<UpdateRoleDTO, Role> {
}
