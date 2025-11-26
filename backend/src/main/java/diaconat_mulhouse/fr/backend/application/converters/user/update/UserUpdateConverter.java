package diaconat_mulhouse.fr.backend.application.converters.user.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UpdateUserDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;

public interface UserUpdateConverter extends Converter<UpdateUserDTO, User> {
}
