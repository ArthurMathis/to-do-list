package diaconat_mulhouse.fr.backend.application.converters.role.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.role.RoleJsonDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.role.Role;

public interface RoleJsonConverter extends Converter<RoleJsonDTO, Role> {
}
