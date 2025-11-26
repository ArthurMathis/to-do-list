package diaconat_mulhouse.fr.backend.application.services.user;

import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.AuthToken;
import diaconat_mulhouse.fr.backend.application.services.CrudService;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.CreateUserDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.LoginUserDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UpdateUserDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.UserJsonDTO;

public interface UserService extends CrudService<Long, UserJsonDTO, CreateUserDTO, UpdateUserDTO> {

    /**
     * Public method that authenticates a user in the system
     *
     * @param loginUserDTO The DTO that contains their login
     * @return The authentification token
     */
    public AuthToken authenticate(LoginUserDTO loginUserDTO);
}
