package diaconat_mulhouse.fr.backend.application.converters.user.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.user.CreateUserDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;

public interface UserCreateConverter extends Converter<CreateUserDTO, User> {
}
