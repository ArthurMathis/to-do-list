package diaconat_mulhouse.fr.backend.core.converters.user.updateUser;

import diaconat_mulhouse.fr.backend.application.DTOs.user.UpdateUserDTO;
import diaconat_mulhouse.fr.backend.core.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

public interface UpdateUserConverter extends Converter<UpdateUserDTO, User> {
}
