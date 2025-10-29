package diaconat_mulhouse.fr.backend.core.converters.user.userJson;

import diaconat_mulhouse.fr.backend.application.DTOs.user.UserJsonDTO;
import diaconat_mulhouse.fr.backend.core.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

public interface UserJsonConverter extends Converter<UserJsonDTO, User> {
}
