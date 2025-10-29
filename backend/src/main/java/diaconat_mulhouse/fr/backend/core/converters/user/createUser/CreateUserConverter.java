package diaconat_mulhouse.fr.backend.core.converters.user.createUser;

import diaconat_mulhouse.fr.backend.application.DTOs.user.CreateUserDTO;
import diaconat_mulhouse.fr.backend.core.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

public interface CreateUserConverter extends Converter<CreateUserDTO, User> {
}
