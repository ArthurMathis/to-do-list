package diaconat_mulhouse.fr.backend.application.converters.user.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UserJsonDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;

public interface UserJsonConverter extends Converter<UserJsonDTO, User> {
}
